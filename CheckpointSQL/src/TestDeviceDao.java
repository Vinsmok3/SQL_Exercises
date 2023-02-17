import java.sql.SQLException;
import java.util.List;

public class TestDeviceDao {
    public static void main(String[] args) throws SQLException {
        String username = "paolo";

        DeviceDao deviceDao = new DeviceDao();

        List<Device> devices = deviceDao.getAllDeviceWithHeartRateAndGps(username);

        for (Device device : devices) {
            String manufacturer = device.getDeviceManufacturer().toLowerCase();
            String model = device.getDeviceModel().toUpperCase();
            String partNumber = device.getDevicePartNumber();
            System.out.println(manufacturer + " " + model + " " + partNumber);
        }
    }
}