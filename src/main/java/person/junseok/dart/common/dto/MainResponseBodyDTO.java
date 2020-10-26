package person.junseok.dart.common.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class MainResponseBodyDTO<T> {
    private String status;
    private String message;
    private String bsns_year;
    private String reprt_code;
    private List<T> list;
}
