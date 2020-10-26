package person.junseok.dart.api.main.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import person.junseok.dart.common.dto.MainResponseBodyDTO;

@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class IsaGamsaJeoncheBosuHyeonhwangDTO extends MainResponseBodyDTO {
    private String rcept_no;
    private String corp_cls;
    private String corp_code;
    private String corp_name;
    private String nmpr;
    private String mendng_totamt;
    private String jan_avrg_mendng_am;
    private String rm;
}
