import java.util.Scanner;

public class Main {
    public static void authorize(){
        System.out.println("1 - login by email\n2 - login by IIN");
        Scanner scanner = new Scanner(System.in);
        var choose = scanner.nextInt();
        switch (choose) {
            case 1 -> {
                System.out.println("Email first, then password ");
                var email = scanner.next();
                var password = scanner.next();
                var user = UserRepository.instance.loginByEmail(email, password);
                if(user == null){
                    System.out.println("Incorrect password");
                }
                else{
                    ConfirmationEmailSender sender = new ConfirmationEmailSender();
                    var code = sender.send(email);
                    System.out.println("Enter code from email");
                    var codeFromEmail = scanner.next();
                    if(codeFromEmail.equals(code)){
                        System.out.println("Login succesfull");
                    }
                    else{
                        System.out.println("Incorrect code");
                    }
                }
            }
            case 2 -> {
                System.out.println("Iin first, then password ");
                var user = UserRepository.instance.loginByIin(scanner.next(), scanner.next());
                if(user == null){
                    System.out.println("Incorrect password");
                }
                else{
                    ConfirmationEmailSender sender = new ConfirmationEmailSender();
                    var code = sender.send(user.email);
                    System.out.println("Enter code from email");
                    if(scanner.next().equals(code)){
                        System.out.println("Login succesfull");
                    }
                    else{
                        System.out.println("Incorrect code");
                    }
                }
            }
            default -> {System.out.println("Incorrect number"); authorize();}
        }
    }
    public static boolean func(AuthEmail userEmail,  AuthIIN userIIN, Scanner sc){
        System.out.println("1 - login by email\n2 - login by IIN");
        Scanner aaa = new Scanner(System.in);
        int a = aaa.nextInt();
        switch (a) {
            case 1 -> {
                int i = 0;
                System.out.println("Email first, then password ");
                while (i != 4) {
                    if (userEmail.checker(sc.nextLine(), sc.nextLine())) {
                        return true;
                    } else {
                        System.out.println("Error");
                        System.out.println("You have " + (3 - i) + " attempts left");
                        i++;
                    }
                }
            }
            case 2 -> {
                int j = 0;
                System.out.println("IIN first, then password ");
                while (j != 4) {
                    if (userIIN.checker(sc.nextLine(), sc.nextLine())) {
                        return true;
                    } else {
                        System.out.println("Error");
                        System.out.println("You have " + (3 - j) + " attempts left");
                        j++;
                    }
                }
            }
            default -> {
                System.out.println("Wrong number");
            }
        }
        return false;
    }
    public static void main(String[] args) {
        authorize();
    }
}
