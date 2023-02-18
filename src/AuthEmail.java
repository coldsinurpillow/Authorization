public class AuthEmail extends Account{
    private static String login;
    public AuthEmail(String login){
        AuthEmail.login = login;
    }
    @Override
    public boolean checker(String login2, String pass2) {
        return Account.getPassword().equals(pass2) && getLogin().equals(login2);
    }
    public static String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        AuthEmail.login = login;
    }
}
