package person.junseok.dart.api.main.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import person.junseok.dart.api.common.dto.ResponseBodyDTO;

@Getter
@Setter
@EqualsAndHashCode
public class BusinessReportDTO {

    private String corpCode;
    private String bsnsYear;
    private String reprtCode;
}
