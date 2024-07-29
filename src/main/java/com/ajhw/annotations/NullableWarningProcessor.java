package com.ajhw.annotations;

import java.lang.reflect.Field;

public class NullableWarningProcessor {
    public void checkFields(Object o) {
        Class<?> processedClass = o.getClass();
        for (Field f : processedClass.getDeclaredFields()) {
            f.setAccessible(true);
            try {
                Object value = f.get(o);
                if (f.isAnnotationPresent(NullableWarning.class) && value == null) {
                    StringBuilder strb = new StringBuilder();
                    strb.append("Variable [")
                            .append(f.getName())
                            .append("] is null in [")
                            .append(processedClass.getSimpleName())
                            .append("]");
                    System.out.println(strb.toString());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }

}
