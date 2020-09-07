package person.junseok.dart.api.main.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class GaeinbyeolBosuJigeubGeumaegDTO {
    private String rcept_no;
    private String corp_cls;
    private String corp_code;
    private String corp_name;
    private String nm;
    private String ofcps;
    private String mendng_totamt;
    private String mendng_totamt_ct_incls_mendng;
}
