package person.junseok.dart.api.main.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import person.junseok.dart.api.API;
import person.junseok.dart.common.GenerateURL;
import person.junseok.dart.common.dto.MainResponseBodyDTO;
import person.junseok.dart.api.main.dto.BaedangeGwanhanSahangDTO;
import person.junseok.dart.api.main.dto.SaeobBogoseoRequestDTO;

@RestController
public class BaedangeGwanhanSahangController {

    private final RestTemplate restTemplate;

    private final GenerateURL<SaeobBogoseoRequestDTO> generateURL;

    private static final String REST_URL = "alotMatter.json";

    public BaedangeGwanhanSahangController(RestTemplate restTemplate, GenerateURL generateURL) {
        this.restTemplate = restTemplate;
        this.generateURL = generateURL;
    }

    @PostMapping("/baedangeGwanhanSahang")
    public MainResponseBodyDTO<BaedangeGwanhanSahangDTO> baedangeGwanhanSahang(@RequestBody SaeobBogoseoRequestDTO saeobBogoseoRequestDTO) throws IllegalAccessException {

         return restTemplate.getForObject(generateURL.execute(REST_URL, saeobBogoseoRequestDTO), MainResponseBodyDTO.class);
    }
}
