package sptech.api_arquivos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.lambda.LambdaClient;
import software.amazon.awssdk.services.lambda.model.InvokeRequest;
import software.amazon.awssdk.services.lambda.model.InvokeResponse;
import software.amazon.awssdk.services.lambda.model.LambdaException;

import java.util.Map;

public class ExemploClienteLambda {
	public static void main(String[] args) {
		String funcao = "py-validar-cpf";
		Region region = Region.US_EAST_1;

		LambdaClient awsLambda = LambdaClient.builder()
				.region(region)
				.build();

		// Objeto para serializar/deserializar JSON
		ObjectMapper objectMapper = new ObjectMapper();

		InvokeResponse res = null;
		try {
			// "json" para enviar ao Lambda
			Map<String, String> parametros = Map.of("cpf", "99999999999");

			// Serializa o objeto para JSON e cria um SdkBytes (que é o payload)
			SdkBytes payload = SdkBytes.fromUtf8String(objectMapper.writeValueAsString(parametros));

			// Configura a requisição para a Lambda
			InvokeRequest request = InvokeRequest.builder()
					.functionName(funcao)
					.payload(payload)
					.build();

			// Invoca a Lambda
			res = awsLambda.invoke(request);

			// Deserializa o JSON de resposta (convertendo para String)
			String value = res.payload().asUtf8String();

			// Deserializa o JSON de resposta (convertendo para objeto do tipo RespostaCpf)
			RespostaCpf respostaCpf =
					objectMapper.readValue(value, RespostaCpf.class);

//			System.out.println(respostaCpf);

			System.out.println();
			if (respostaCpf.valido()) {
				System.out.println("Parabéns! CPF válido!");
			} else {
				System.out.println("#deuruim CPF inválido! Motivo: " + respostaCpf.resultado());
			}

		} catch (LambdaException | JsonProcessingException e) {
			System.err.println(e.getMessage());
		}


		awsLambda.close();
	}
}
