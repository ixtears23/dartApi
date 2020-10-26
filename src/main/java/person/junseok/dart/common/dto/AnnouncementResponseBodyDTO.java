package person.junseok.dart.common.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class AnnouncementResponseBodyDTO<T> {
    private String status;
    private String message;
    private String page_no;
    private String page_count;
    private String total_count;
    private String total_page;
    private List<T> list;
}
