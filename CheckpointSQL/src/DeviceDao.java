import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeviceDao {
    public List<Device> getAllDeviceWithHeartRateAndGps(String username) throws SQLException {
        List<Device> devices = new ArrayList<>();

        String query = "SELECT * FROM device WHERE username = ? AND DEVICE_HAS_GPS = true AND DEVICE_HAS_HEARTRATE = true";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Device device = new Device();
                device.setDevicePartNumber(resultSet.getString("DEVICE_PART_NUMBER"));
                device.setDeviceManufacturer(resultSet.getString("Device_Manufacturer"));
                device.setDeviceModel(resultSet.getString("device_Model"));
                device.setDeviceHasGps(resultSet.getShort("device_Has_Gps"));
                device.setDeviceHasHeartRate(resultSet.getShort("device_Has_HeartRate"));
                devices.add(device);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }

        return devices;
    }

}