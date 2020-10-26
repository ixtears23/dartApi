package person.junseok.dart.api.announcement.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@Builder
public class GongsiJeongboRequestDTO {
    private String corp_code;
    private String bgn_de;
    private String end_de;
    private String last_reprt_at;
    private String pblntf_ty;
    private String pblntf_detail_ty;
    private String corp_cls;
    private String sort;
    private String sort_mth;
    private String page_no;
    private String page_count;
}
