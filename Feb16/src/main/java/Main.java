import java.sql.SQLException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserDao dao = new UserDao();
        Optional<User> user = dao.getUserData("checkpoint");
        if(user.isPresent()){
            System.out.println(user.get());
        } else {
            System.out.println("utente non trovato");
        }
        dao.fetchAllActiveUser();
        dao.printAllActiveUser();

        MessageDao messageDao = new MessageDao();
        System.out.println(messageDao.getMessageWithCommentById(2l));
    }
}
