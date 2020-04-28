package JarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<String> jarOfPickles = new Jar<String>();
      jarOfPickles.add("first");
      jarOfPickles.add("second");
        System.out.println(jarOfPickles.remove());
        System.out.println();
    }
}
