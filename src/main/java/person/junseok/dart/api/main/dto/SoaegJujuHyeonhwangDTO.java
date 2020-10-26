package person.junseok.dart.api.main.dto;

import lombok.*;
import person.junseok.dart.api.common.dto.MainResponseBodyDTO;

@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class SoaegJujuHyeonhwangDTO extends MainResponseBodyDTO {
    private String rcept_no;
    private String corp_cls;
    private String corp_code;
    private String corp_name;
    private String se;
    private String shrholdr_co;
    private String shrholdr_tot_co;
    private String shrholdr_rate;
    private String hold_stock_co;
    private String stock_tot_co;
    private String hold_stock_rate;
}
