import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
public class TrainingDao {
    public TrainingSessionWithData getTrainingSessionDataByTrainingId(Integer trainingId) throws SQLException {
        TrainingSessionData session;
        List<TrainingSessionData> trainingSessionData = new ArrayList<>();
        String sessionQuery = "SELECT * FROM TRAINING_SESSION WHERE ID = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");
             PreparedStatement statement = connection.prepareStatement(sessionQuery)) {
            statement.setInt(1, trainingId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                session = new TrainingSessionData(
                        resultSet.getInt("ID_TRAINING_SESSION_DATA"),

                )
            }
    }
}

*/