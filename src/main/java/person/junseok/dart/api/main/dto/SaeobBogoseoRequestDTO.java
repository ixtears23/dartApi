package person.junseok.dart.api.main.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@Builder
public class SaeobBogoseoRequestDTO {

    private String corpCode;
    private String bsnsYear;
    private String reprtCode;
}
