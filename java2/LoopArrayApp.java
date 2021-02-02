public class LoopArrayApp {
    public static void main(String[] args) {
        /**
         * <li>junhwanyun</li>
         * <li>junhwan</li>
         * <li>yun</li>
         */
        String[] users = new String[3];

        users[0] = "junhwanyun";
        users[1] = "junhwan";
        users[2] = "yun";

        for(int i = 0; i < users.length; i++) {
            System.out.println("<li>" + users[i] + "</li>");
        }
    }
}