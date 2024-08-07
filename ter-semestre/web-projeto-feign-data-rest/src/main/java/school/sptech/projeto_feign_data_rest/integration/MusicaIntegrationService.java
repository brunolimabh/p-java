package school.sptech.projeto_feign_data_rest.integration;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicaIntegrationService {

    private final MusicaClient musicaClient;

    public List<MusicaRespostaDto> listar() {
        ResponseEntity<List<MusicaRespostaDto>> response = musicaClient.listar();

        if (response.getStatusCode().value() == 204) {
            throw new ResponseStatusException((HttpStatus.NOT_FOUND));
        }

        return response.getBody();
    }

}
