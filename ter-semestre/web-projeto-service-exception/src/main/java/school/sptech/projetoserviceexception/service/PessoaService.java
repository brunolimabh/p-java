package school.sptech.projetoserviceexception.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.sptech.projetoserviceexception.dto.pessoa.PessoaMapper;
import school.sptech.projetoserviceexception.dto.pessoa.PessoaRequest;
import school.sptech.projetoserviceexception.entity.Pessoa;
import school.sptech.projetoserviceexception.exception.ConflitoException;
import school.sptech.projetoserviceexception.exception.NaoEncontradoException;
import school.sptech.projetoserviceexception.repository.PessoaRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public Pessoa criar(PessoaRequest request) {
        if (pessoaRepository.existsByEmail(request.getEmail())) throw new ConflitoException("Pessoa EMAIL");
        Pessoa entity = PessoaMapper.toEntity(request);
        Pessoa saveEntity = pessoaRepository.save(entity);
        return saveEntity;
    }

    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    public Pessoa listarPorId(int id) {
        return pessoaRepository.findById(id).orElseThrow(
                () -> new NaoEncontradoException("Pessoa")
        );
    }

}
