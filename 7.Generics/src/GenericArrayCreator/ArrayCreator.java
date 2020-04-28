package GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {
    public static <T> T[] create(int length, T item){
       var array = (T[])new Object[length];
        setValue(length, item, array);
        return array;
    }

    private static <T> T[] setValue(int length, T item, T[] array) {
        for (int i = 0; i < length; i++) {
            array[i] = (T) item;
        }
        return array;
    }

    public static <T> T[] create(Class<T> clazz, int length, T item){
        T[] array = (T[]) Array.newInstance(clazz, length);

        setValue(length, item, array);
        return array;
    }
}
