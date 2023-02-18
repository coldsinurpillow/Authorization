import java.sql.*;

public class UserRepository {
    public static final UserRepository instance = new UserRepository();
    private final Connection connection;
    private UserRepository(){
        this.connection = JDBCConnection.connection;
    }
    public UserModel loginByEmail(String email, String password) {
        var user = new UserModel();
        try {
            String sql = "SELECT * FROM users WHERE email=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                user.email = email;
                user.firstname = rs.getString("firstname");
                user.lastname = rs.getString("lastname");
                user.iin = rs.getString("iin");
                user.password = rs.getString("password");
                if(!ComparePassword(password, user.password)){
                    return null;
                }
                return user;
            }
        } catch (SQLException throwable){
            throwable.printStackTrace();
        }
        return user;
    }

    public UserModel loginByIin(String iin, String password) {
        var user = new UserModel();
        try {
            String sql = "SELECT * FROM users WHERE iin=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, iin);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                user.iin = iin;
                user.firstname = rs.getString("firstname");
                user.lastname = rs.getString("lastname");
                user.email = rs.getString("email");
                user.password = rs.getString("password");
                if(!ComparePassword(password, user.password)){
                    return null;
                }
                return user;
            }
        } catch (SQLException throwable){
            throwable.printStackTrace();
        }
        return user;
    }
    public boolean ComparePassword(String password, String HashedPassword) {
        var hasher = new Hasher();
        try {
            return hasher.generateHmac256(password, Hasher.key).equals(HashedPassword);
        } catch (Exception ignored){

        }
        return false;
    }
}


