package person.junseok.dart.api.main.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import person.junseok.dart.api.common.dto.MainResponseBodyDTO;

@Getter
@EqualsAndHashCode
public class ChoedaeJujuHyeonhwangDTO extends MainResponseBodyDTO {
    private String rcept_no;
    private String corp_cls;
    private String corp_code;
    private String corp_name;
    private String nm;
    private String relate;
    private String stock_knd;
    private String bsis_posesn_stock_co;
    private String bsis_posesn_stock_qota_rt;
    private String trmend_posesn_stock_co;
    private String trmend_posesn_stock_qota_rt;
    private String rm;
}
