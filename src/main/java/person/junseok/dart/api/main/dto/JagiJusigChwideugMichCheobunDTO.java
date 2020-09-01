package person.junseok.dart.api.main.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import person.junseok.dart.api.common.dto.ResponseBodyDTO;

@Getter
@EqualsAndHashCode
public class JagiJusigChwideugMichCheobunDTO extends ResponseBodyDTO {
    private String rcept_no;
    private String corp_cls;
    private String corp_code;
    private String corp_name;
    private String acqs_mth1;
    private String acqs_mth2;
    private String acqs_mth3;
    private String stock_knd;
    private String bsis_qy;
    private String change_qy_acqs;
    private String change_qy_dsps;
    private String change_qy_incnr;
    private String trmend_qy;
    private String rm;

}
