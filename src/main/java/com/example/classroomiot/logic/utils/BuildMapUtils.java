package com.example.classroomiot.logic.utils;

import com.example.classroomiot.logic.utils.error.CustomException;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * BuildMapUtils
 *
 */
@Component
public class BuildMapUtils {

    /**
     * buildMapSearch : convert Object to Map using search in database
     *
     * @param object : Object using convert to Map
     * @return Map <String,Object>
     */
    public Map<String, Object> buildMapSearch(Object object) {
        Map<String, Object> result = new HashMap<>();
        try {
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.get(object) != null && !field.get(object).equals("")) {
                    if (field.get(object) instanceof Integer) {
                        result.put(field.getName().toLowerCase(), field.get(object));
                    } else if (field.get(object) instanceof Long) {
                        result.put(field.getName().toLowerCase(), field.get(object));
                    } else {
                        if (!field.getName().contains("Date")) {
                            result.put(field.getName().toLowerCase(), BuildQueryUtils.formatLikeStringSql(field.get(object).toString().trim()));
                        } else {
                            if (field.getName().contains("Date")) {
                                result.put(field.getName().toLowerCase(), DateTimeUtils.convertStringRequestToTimesTamp(DateTimeUtils.formatDateTimeQuery(field.get(object).toString().trim()), "dd/MM/yyyy"));
                            }
                        }
                    }
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException | ParseException e) {
            throw new CustomException("build map fails", CommonUtils.putError("class", "ERR_002"));
        }
        return result;
    }

    public Map<String , String> convertDtoToMap(Object obj){
        Map<String , String> result = new HashMap<>();
        for (Field field: obj.getClass().getDeclaredFields()){
            field.setAccessible(true);
            try {
                if(field.get(obj) != null){
                    result.put(field.getName(), field.get(obj).toString());
                }
            }catch (Exception e){
                throw new CustomException(e.getMessage());
            }
        }
        return result;
    }
}
