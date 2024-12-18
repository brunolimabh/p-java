package sptech.api_arquivos;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteResource {

	private final ClienteRepository repository;

	private S3Client criarClienteS3() {
		Region region = Region.US_EAST_1;
		S3Client s3 = S3Client.builder().region(region).build();
		return s3;
	}

		private void enviarArquivoS3(String nomeArquivo, byte[] conteudoArquivo) {
		PutObjectRequest putObjectRequest = PutObjectRequest.builder()
				.bucket("recordacoes")
				.key(nomeArquivo)
				.build();

		Path path = Paths.get("download.jpg");

		software.amazon.awssdk.core.sync.RequestBody requestBody =
				software.amazon.awssdk.core.sync.RequestBody.fromBytes(conteudoArquivo);

		S3Client s3 = criarClienteS3();
		s3.putObject(putObjectRequest, requestBody);
	}

	private byte[] baixarArquivoS3(String nomeArquivo) {
		GetObjectRequest getObjectRequest = GetObjectRequest.builder()
				.bucket("recordacoes")
				.key(nomeArquivo)
				.build();

		S3Client s3 = criarClienteS3();

		byte[] arquivo = s3.getObjectAsBytes(getObjectRequest).asByteArray();
		return arquivo;
	}

	@PostMapping
	public ResponseEntity<Cliente> criar(@RequestBody @Valid Cliente cliente) {
		repository.save(cliente);
		return ResponseEntity.status(201).body(cliente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable long id, @RequestBody @Valid Cliente cliente) {
		if (!repository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		cliente.setId(id);
		repository.save(cliente);
		return ResponseEntity.status(200).body(cliente);
	}

	@PatchMapping(value = "/foto/{id}", consumes = "image/*")
	public ResponseEntity<Void> atualizarFoto(@PathVariable Long id,
											  @RequestBody byte[] referenciaArquivoFoto) {
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		String nomeArquivo = "foto-cliente-%d.jpg".formatted(id);

		enviarArquivoS3(nomeArquivo, referenciaArquivoFoto);

		repository.updateReferenciaArquivoFoto(id, nomeArquivo);

		return ResponseEntity.ok().build();
	}

	@PatchMapping(value = "/relatorio/{id}", consumes = "application/pdf")
	public ResponseEntity<Void> atualizarRelatorio(@PathVariable Long id,
												   @RequestBody byte[] referenciaArquivoRelatorio) {
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		String nomeArquivo = "relatorio-cliente-%d.pdf".formatted(id);

		enviarArquivoS3(nomeArquivo, referenciaArquivoRelatorio);

		repository.updateReferenciaArquivoRelatorio(id, nomeArquivo);

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/foto/{id}", produces = "image/jpeg")
	public ResponseEntity<byte[]> getFoto(@PathVariable Long id) {
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		String referenciaArquivoFoto = repository.findReferenciaArquivoFotoById(id);

		byte[] arquivo = baixarArquivoS3(referenciaArquivoFoto);

		return ResponseEntity.ok(arquivo);
	}

	@GetMapping(value = "/relatorio/{id}", produces = "application/pdf")
	public ResponseEntity<byte[]> getRelatorio(@PathVariable Long id) {
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		String referenciaArquivoRelatorio = repository.findReferenciaArquivoRelatorioById(id);

		byte[] arquivo = baixarArquivoS3(referenciaArquivoRelatorio);
		return ResponseEntity.ok(arquivo);
	}
}
