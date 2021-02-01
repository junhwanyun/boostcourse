public class AuthApp2 {
    public static void main(String[] args) {
        String id = "junhwanyun";
        String inputId = args[0];

        String password = "777";
        String password2 = "123";
        String inputPassword = args[1];

        boolean isRightPassword = inputPassword.equals(password) || inputPassword.equals(password2);

        System.out.println("Hello,");
        
        if(inputId.equals(id) && isRightPassword) {
            System.out.println("Master!");
        }else {
            System.out.println("Who are you?");
        }
    }
}