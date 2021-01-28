public class AuthApp {
    public static void main(String[] args) {
        String id = "junhwanyun";
        String inputId = args[0];

        String password = "777";
        String inputPassword = args[1];

        System.out.println("Hello,");

        // if(inputId == id) {
        // if(inputId.equals(id)) {
        //     if(inputPassword.equals(password)) {
        //         System.out.println("Master!");
        //     }else {
        //         System.out.println("Wrong password!");
        //     }
        // }else {
        //     System.out.println("Who are you?");
        // }

        if(inputId.equals(id) && inputPassword.equals(password)) {
            System.out.println("Master!");
        }else {
            System.out.println("Who are you?");
        }
    }
}