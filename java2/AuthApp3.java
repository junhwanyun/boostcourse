public class AuthApp3 {
    public static void main(String[] args) {
        //String[] users = {"junhwanyun", "junhwan", "yun"};
        String[][] users = {
            {"junhwanyun", "111"},
            {"junhwan", "222"},
            {"yun", "333"}
        };

        String inputId = args[0];
        String inputPassword = args[1];

        boolean isLogined = false;

        for(int i = 0; i < users.length; i++) {
            if(users[i][0].equals(inputId) && users[i][1].equals(inputPassword)) {
                isLogined = true;

                break;
            }
        }

        System.out.println("Hello,");

        if(isLogined) {
            System.out.println("junhwanyun!");
        }else {
            System.out.println("Who are you?");
        }
    }
}