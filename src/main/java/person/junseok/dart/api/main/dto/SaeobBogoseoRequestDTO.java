package person.junseok.dart.api.main.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@Builder
public class SaeobBogoseoRequestDTO {

    private String corp_code;
    private String bsns_year;
    private String reprt_code;
}
