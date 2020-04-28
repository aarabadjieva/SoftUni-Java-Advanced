package GenericArrayCreator;

public class Main {
    public static void main(String[] args) {

       Integer[] ints = ArrayCreator.create(Integer.class, 10, 100);
       int count=-1;
        for (Integer integer:ints
             ) {
            System.out.println(++count + " " + integer);
        }
        String[] strings =  ArrayCreator.create(10, "none");
         count = 0;
        for (String string:strings
        ) {
            System.out.println(count++ + " " + string);
        }
    }
}
