package person.junseok.dart.api.main.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import person.junseok.dart.api.common.dto.ResponseBodyDTO;

@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class ImwonHyeonhwangDTO extends ResponseBodyDTO {
    private String rcept_no;
    private String corp_cls;
    private String corp_code;
    private String corp_name;
    private String nm;
    private String sexdstn;
    private String birth_ym;
    private String ofcps;
    private String rgist_exctv_at;
    private String fte_at;
    private String chrg_job;
    private String main_career;
    private String mxmm_shrholdr_relate;
    private String hffc_pd;
    private String tenure_end_on;
}