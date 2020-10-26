package person.junseok.dart.api.main.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import person.junseok.dart.api.API;
import person.junseok.dart.api.common.dto.MainResponseBodyDTO;
import person.junseok.dart.api.main.dto.GaeinbyeolBosuJigeubGeumaegDTO;
import person.junseok.dart.api.main.dto.SaeobBogoseoRequestDTO;

@RestController
public class GaeinbyeolBosuJigeubGeumaegController {

    private final RestTemplate restTemplate;

    private static final String REST_URL = "https://opendart.fss.or.kr/api/indvdlByPay.json";

    public GaeinbyeolBosuJigeubGeumaegController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/gaeinbyeolBosuJigeubGeumaeg")
    public MainResponseBodyDTO<GaeinbyeolBosuJigeubGeumaegDTO> gaeinbyeolBosuJigeubGeumaeg(@RequestBody SaeobBogoseoRequestDTO saeobBogoseoRequestDTO) {

        String requestUrl = String.format("%s?crtfc_key=%s&corp_code=%s&bsns_year=%s&reprt_code=%s",
                REST_URL,
                API.KEY.getValue(),
                saeobBogoseoRequestDTO.getCorpCode(),
                saeobBogoseoRequestDTO.getBsnsYear(),
                saeobBogoseoRequestDTO.getReprtCode());
        return restTemplate.getForObject(requestUrl, MainResponseBodyDTO.class);
    }
}
