package person.junseok.dart.api.announcement.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import person.junseok.dart.api.announcement.dto.GongsiJeongboRequestDTO;
import person.junseok.dart.api.announcement.dto.GongsigeomSaegDTO;
import person.junseok.dart.common.GenerateURL;
import person.junseok.dart.common.dto.AnnouncementResponseBodyDTO;

@RestController
public class GongsiGeomsaegController {

    private final RestTemplate restTemplate;

    private GenerateURL<GongsiJeongboRequestDTO> generateURL;

    private static final String REST_URL = "list.json";

    public GongsiGeomsaegController(RestTemplate restTemplate, GenerateURL generateURL) {
        this.restTemplate = restTemplate;
        this.generateURL = generateURL;
    }

    @PostMapping("/gongsiGeomsaeg")
    public AnnouncementResponseBodyDTO<GongsigeomSaegDTO> gongsiGeomsaeg(@RequestBody GongsiJeongboRequestDTO gongsiJeongboRequestDTO) throws IllegalAccessException {

        return restTemplate.getForObject(generateURL.execute(REST_URL, gongsiJeongboRequestDTO), AnnouncementResponseBodyDTO.class);
    }

}
