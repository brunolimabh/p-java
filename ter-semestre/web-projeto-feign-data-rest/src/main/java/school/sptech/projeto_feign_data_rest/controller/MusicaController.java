package school.sptech.projeto_feign_data_rest.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.projeto_feign_data_rest.integration.MusicaIntegrationService;
import school.sptech.projeto_feign_data_rest.integration.MusicaRespostaDto;

import java.util.List;

@RestController
@RequestMapping("/musicas")
@RequiredArgsConstructor
public class MusicaController {

    private final MusicaIntegrationService musicaIntegrationService;

    @GetMapping
    public ResponseEntity<List<MusicaRespostaDto>> listar() {
        return ResponseEntity.ok(musicaIntegrationService.listar());
    }

}
