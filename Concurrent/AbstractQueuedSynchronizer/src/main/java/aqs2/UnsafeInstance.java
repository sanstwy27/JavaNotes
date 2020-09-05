package aqs2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Sanstwy27
 * @create 9/5/2020
 */

public class UnsafeInstance {
    public static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
