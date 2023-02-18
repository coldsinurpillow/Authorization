public class Account {
    private static String login, iin;
    private static String password;
    private String code;
    public Account(String login, String iin, String password){
        Account.login = login;
        Account.iin = iin;
        Account.password = password;
    }
    public Account(String code){
        this.code = code;
    }
    public Account() {}
    public static String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        Account.password = password;
    }
    public static String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        Account.login = login;
    }
    public static String getIIN() {
        return iin;
    }
    public void setIIN(String iin) {
        Account.iin = iin;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCode(){
        return code;
    }

    public void checkpass(){
        int up = 0, low = 0, digit = 0;
        for(int i = 0; i < Account.password.length(); i++) {
            if (Character.isUpperCase(Account.password.charAt(i))) {
                up++;
            } else if (Character.isLowerCase(Account.password.charAt(i))) {
                low++;
            } else if (Character.isDigit(Account.password.charAt(i))) {
                digit++;
            }
        }
        if(up == 0 || low == 0 || digit == 0){
            System.out.println("Your password is pathetic, we recommend you to change it");
        }
        if(Account.password.length() < 6){
            System.out.println("Your password is too short, we recommend you to change it");
        }
    }
    public boolean checker(String name, String password) {
        return false;
    }
}

