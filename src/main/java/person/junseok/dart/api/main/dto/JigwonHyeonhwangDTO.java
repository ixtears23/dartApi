package person.junseok.dart.api.main.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import person.junseok.dart.api.common.dto.MainResponseBodyDTO;

@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class JigwonHyeonhwangDTO extends MainResponseBodyDTO {
    private String rcept_no;
    private String corp_cls;
    private String corp_code;
    private String corp_name;
    private String fo_bbm;
    private String sexdstn;
    private String reform_bfe_emp_co_rgllbr;
    private String reform_bfe_emp_co_cnttk;
    private String reform_bfe_emp_co_etc;
    private String rgllbr_co;
    private String rgllbr_abacpt_labrr_co;
    private String cnttk_co;
    private String cnttk_abacpt_labrr_co;
    private String sm;
    private String avrg_cnwk_sdytrn;
    private String fyer_salary_totamt;
    private String jan_salary_am;
    private String rm;
}