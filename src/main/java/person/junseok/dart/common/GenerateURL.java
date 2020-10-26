package person.junseok.dart.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import person.junseok.dart.api.API;

import java.lang.reflect.Field;

@Component
public class GenerateURL<T> {

    @Value( "${dart.url}" )
    private String restUrl;

    public String execute(String apiUrl, T dto) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder(restUrl).append(apiUrl);
        Field[] declaredFields = dto.getClass().getDeclaredFields();

        sb.append("?crtfc_key=").append(API.KEY.getValue()).append("&");

        for (int i = 0; i < declaredFields.length; i++) {
            Field f = declaredFields[i];
            f.setAccessible(true);

            if(f.get(dto) != null && !"".equals(f.get(dto))) {
                sb.append(f.getName()).append("=").append(f.get(dto));

                if(i < (declaredFields.length - 1)) {
                    sb.append("&");
                }
            }
        }
        return sb.toString();
    }
}
