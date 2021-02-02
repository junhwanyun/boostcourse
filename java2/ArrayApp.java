public class ArrayApp {
    public static void main(String[] args) {
        //junhwanyun, junhwan, tun
        // String users = "junhwanyun, junhwan, yun";
        String[] users = new String[3];

        users[0] = "junhwanyun";
        users[1] = "junhwan";
        users[2] = "yun";

        System.out.println(users[1]);
        System.out.println(users.length);

        int[] scores = {100, 50, 0}; // 원소(element)

        System.out.println(scores[1]);
        System.out.println(scores.length);
    }
}