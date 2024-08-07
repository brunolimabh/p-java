package school.sptech.projeto_feign_data_rest.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "music-box", url = "https://633607188aa85b7c5d274257.mockapi.io/music-box")
public interface MusicaClient {

    @RequestMapping(
            method = RequestMethod.GET
    )
    ResponseEntity<List<MusicaRespostaDto>> listar();

}
