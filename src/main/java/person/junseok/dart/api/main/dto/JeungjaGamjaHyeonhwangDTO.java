package person.junseok.dart.api.main.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import person.junseok.dart.common.dto.MainResponseBodyDTO;

@Getter
@Setter
@EqualsAndHashCode
public class JeungjaGamjaHyeonhwangDTO extends MainResponseBodyDTO {
    private String rcept_no;
    private String corp_cls;
    private String corp_code;
    private String corp_name;
    private String isu_dcrs_de;
    private String isu_dcrs_stle;
    private String isu_dcrs_stock_knd;
    private String isu_dcrs_qy;
    private String isu_dcrs_mstvdv_fval_amount;
    private String isu_dcrs_mstvdv_amount;
}
