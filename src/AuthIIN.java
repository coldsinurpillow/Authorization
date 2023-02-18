public class AuthIIN extends Account{
    private static String iin;
    public AuthIIN(String iin){
        AuthIIN.iin = iin;
    }
    public AuthIIN() {}
    @Override
    public boolean checker(String iin, String pass2) {
        return Account.getPassword().equals(pass2) && getIIN().equals(iin);
    }
    public static String getIIN() {
        return iin;
    }
    public void setIIN(String iin) {
        AuthIIN.iin = iin;
    }
}
