import java.text.ParseException;

public class EqualsApp {
    public static void main(String[] args) throws ParseException {
        int p1 = 1;
        int p2 = 1;

        System.out.println(p1 == p2);

        String o1 = "java";
        String o2 = new String("java");

        System.out.println(o1 == o2);
        System.out.println(o1.equals(o2));

        String s1 = "java";
        String s2 = "java";

        System.out.println(s1 == s2);
    }
}