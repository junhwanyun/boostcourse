public class AuthApp3 {
    public static void main(String[] args) {
        String[] users = {"junhwanyun", "junhwan", "yun"};

        String inputId = args[0];

        boolean isLogined = false;

        for(int i = 0; i < users.length; i++) {
            if(users[i].equals(inputId)) {
                isLogined = true;

                break;
            }
        }

        System.out.println("Hello,");
        
        if(isLogined) {
            System.out.println("yunhwanyun!");
        }else {
            System.out.println("Who are you?");
        }
    }
}