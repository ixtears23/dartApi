package person.junseok.dart.api.main.dto;

import lombok.*;
import person.junseok.dart.api.common.dto.ResponseBodyDTO;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class BaedangeGwanhanSahangDTO extends ResponseBodyDTO {
    private String rcept_no;
    private String corp_cls;
    private String corp_code;
    private String corp_name;
    private String se;
    private String stock_knd;
    private String thstrm;
    private String frmtrm;
    private String lwfr;
}
