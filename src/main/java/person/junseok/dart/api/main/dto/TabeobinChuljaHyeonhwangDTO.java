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
public class TabeobinChuljaHyeonhwangDTO extends MainResponseBodyDTO {
    private String rcept_no;
    private String corp_cls;
    private String corp_code;
    private String corp_name;
    private String inv_prm;
    private String frst_acqs_de;
    private String invstmnt_purps;
    private String frst_acqs_amount	;
    private String bsis_blce_qy;
    private String bsis_blce_qota_rt;
    private String bsis_blce_acntbk_amount;
    private String incrs_dcrs_acqs_dsps_qy;
    private String incrs_dcrs_acqs_dsps_amount;
    private String incrs_dcrs_evl_lstmn;
    private String trmend_blce_qy;
    private String trmend_blce_qota_rt;
    private String trmend_blce_acntbk_amount;
    private String recent_bsns_year_fnnr_sttus_tot_assets;
    private String recent_bsns_year_fnnr_sttus_thstrm_ntpf;
}
