import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserDao {
    private final String QUERY_SELECT_ALL ="SELECT * FROM USER WHERE 'username' = ? ";
    private final String QUERY_FECTH_ACTIVE_USER = " SLECT * FROM USER WHERE 'username' <>0";
    private Map<String,User> activeUser = new HashMap();
    ResultSet rs = null;

    public Optional<User> getUserData(String username) throws SQLException {

        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "developer", "passwordhere");
            PreparedStatement s = c.prepareStatement(QUERY_SELECT_ALL);
            s.setString(1, "pasquale");
            rs = s.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getDate("registation"),
                        rs.getShort("active"));
                return Optional.of(user);
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

          if(rs!=null)  rs.close();
        }
    }

    public void fetchAllActiveUser() throws SQLException{
        try( Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "developer", "passwordhere");
             PreparedStatement s = c.prepareStatement(QUERY_FECTH_ACTIVE_USER);){
            while (rs.next()){User user = new User(rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getDate("registation"),
                    rs.getShort("active"));
                activeUser.put(user.getUsername(),user);
        }
    }
 }

 public void printAllActiveUser(){
     for (String key : activeUser.keySet()) {
         System.out.println(activeUser.get(key));
     }
 }
}


try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "snow");
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM device WHERE DEVICE_HAS_GPS != ? and DEVICE_HAS_HEARTRATE != ? and USERNAME = ?");
        ps.setInt(1, 0);
        ps.setInt(2, 0);
        ps.setString(3, username);
        rs = ps.executeQuery();
        while (rs.next()) {
        dev = new Device(rs.getString("DEVICE_PART_NUMBER"),
        rs.getString("DEVICE_MANUFACTURER"),
        rs.getString("DEVICE_MODEL"),
        rs.getShort("DEVICE_HAS_GPS"),
        rs.getShort("DEVICE_HAS_HEARTRATE"),
        rs.getString("USERNAME"));
        list.add(dev);
        }
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }
        return list;