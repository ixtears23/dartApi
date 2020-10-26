package person.junseok.dart.api.announcement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import person.junseok.dart.common.dto.AnnouncementResponseBodyDTO;

@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class GongsigeomSaegDTO extends AnnouncementResponseBodyDTO {
    private String corp_cls;
    private String corp_name;
    private String corp_code;
    private String stock_code;
    private String report_nm;
    private String rcept_no;
    private String flr_nm;
    private String rcept_dt;
    private String rm;
}
