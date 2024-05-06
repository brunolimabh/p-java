package school.sptech.projetoserviceexception.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.sptech.projetoserviceexception.dto.estabelecimento.EstabelecimentoMapper;
import school.sptech.projetoserviceexception.dto.estabelecimento.EstabelecimentoRequest;
import school.sptech.projetoserviceexception.dto.estabelecimento.EstabelecimentoVincularRequest;
import school.sptech.projetoserviceexception.entity.Estabelecimento;
import school.sptech.projetoserviceexception.entity.Pessoa;
import school.sptech.projetoserviceexception.exception.ConflitoException;
import school.sptech.projetoserviceexception.exception.NaoEncontradoException;
import school.sptech.projetoserviceexception.repository.EstabelecimentoRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstabelecimentoService {

    private final EstabelecimentoRepository estabelecimentoRepository;
    private final PessoaService pessoaService;

    public Estabelecimento criar(EstabelecimentoRequest request) {
        if (estabelecimentoRepository.existsByCnpj(request.getCnpj())) throw new ConflitoException("Estabelecimento CNPJ");
        Estabelecimento entity = EstabelecimentoMapper.toEntity(request);
        Estabelecimento saveEntity = estabelecimentoRepository.save(entity);
        return saveEntity;
    }

    public List<Estabelecimento> listar() {
        return estabelecimentoRepository.findAll();
    }

    public Estabelecimento listarPorId(int id) {
        return estabelecimentoRepository.findById(id).orElseThrow(
                () -> new NaoEncontradoException("Estabelecimento")
        );
    }

    public Estabelecimento vincular(EstabelecimentoVincularRequest request) {
        Estabelecimento estabelecimento = listarPorId(request.getEstabelecimentoId());
        Pessoa pessoa = pessoaService.listarPorId(request.getPessoaId());
        estabelecimento.setPessoa(pessoa);
        Estabelecimento saveEntity = estabelecimentoRepository.save(estabelecimento);
        return saveEntity;

    }

}
