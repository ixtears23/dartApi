package person.junseok.dart.api.main.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import person.junseok.dart.common.dto.MainResponseBodyDTO;

@Getter
@EqualsAndHashCode
public class ChoedaeJujuByeondongHyeonhwangDTO extends MainResponseBodyDTO {
    private String rcept_no;
    private String corp_cls;
    private String corp_code;
    private String corp_name;
    private String change_on;
    private String mxmm_shrholdr_nm;
    private String posesn_stock_co;
    private String qota_rt;
    private String change_cause;
    private String rm;
}
