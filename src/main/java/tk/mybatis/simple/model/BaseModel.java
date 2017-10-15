package tk.mybatis.simple.model;

import java.lang.reflect.Field;

public class BaseModel {
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Field[] fields = getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                sb.append(field.getName()).append(":").append(field.get(this)).append(", ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 去掉多于的逗号
        if(sb.length() > 1){
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append("]");
        return sb.toString();
    }
}
