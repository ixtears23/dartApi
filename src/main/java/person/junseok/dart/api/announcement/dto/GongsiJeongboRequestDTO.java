package person.junseok.dart.api.announcement.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@Builder
public class GongsiJeongboRequestDTO {
    private String corpCode;
    private String bgnDe;
    private String endDe;
    private String lastReprtAt;
    private String pblntfTy;
    private String pblntfDetailTy;
    private String corpCls;
    private String sort;
    private String sortMth;
    private String pageNo;
    private String pageCount;
}
