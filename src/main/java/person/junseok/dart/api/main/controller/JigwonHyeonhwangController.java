package person.junseok.dart.api.main.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import person.junseok.dart.api.API;
import person.junseok.dart.api.common.dto.ResponseBodyDTO;
import person.junseok.dart.api.main.dto.ImwonHyeonhwangDTO;
import person.junseok.dart.api.main.dto.JigwonHyeonhwangDTO;
import person.junseok.dart.api.main.dto.SaeobBogoseoRequestDTO;

@RestController
public class JigwonHyeonhwangController {

    private final RestTemplate restTemplate;

    private static final String REST_URL = "https://opendart.fss.or.kr/api/empSttus.json";

    public JigwonHyeonhwangController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/jigwonHyeonhwang")
    public ResponseBodyDTO<JigwonHyeonhwangDTO> imwonHyeonhwang(@RequestBody SaeobBogoseoRequestDTO saeobBogoseoRequestDTO) {

        String requestUrl = String.format("%s?crtfc_key=%s&corp_code=%s&bsns_year=%s&reprt_code=%s",
                REST_URL,
                API.KEY.getValue(),
                saeobBogoseoRequestDTO.getCorpCode(),
                saeobBogoseoRequestDTO.getBsnsYear(),
                saeobBogoseoRequestDTO.getReprtCode());
        return restTemplate.getForObject(requestUrl, ResponseBodyDTO.class);
    }
}
