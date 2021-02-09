public class WhyMethodApp {
    public static void main(String[] args) {
        // 100000000
        printTwoTimes("a", "-");
        // 100000000
        printTwoTimes("a", "*");
        // 100000000
        printTwoTimes("a", "&");
        // argument(인자)
        printTwoTimes("b", "!");
    }

    // parameter(매개변수)
    public static void printTwoTimes(String str, String dlmtr) {
        System.out.println(dlmtr);
        System.out.println(str);
        System.out.println(str);
    }
}