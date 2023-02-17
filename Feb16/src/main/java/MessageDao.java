import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDao {

    private String GET_MESSAGE_WITH_COMMENT_BY_ID = "SELECT m.*,c.* FROM MESSAGE m LEFT JOIN COMMENT c ON m.id_message = c.id_message where m.idmessage =?";

    public List<MessageWithComment> getMessageWithCommentById(Long idMessage) throws SQLException {
        ResultSet rs = null;
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "password");
             PreparedStatement s = c.prepareStatement(GET_MESSAGE_WITH_COMMENT_BY_ID)){
            s.setLong(1,idMessage);
            rs=s.executeQuery();
            List<MessageWithComment> messages = new ArrayList<>();
            while (rs.next()){
                MessageWithComment message = new MessageWithComment();
                message.setIdMessage(rs.getLong("c.id_comment"));
                message.setIdMessage(rs.getLong("c.id_message"));
                message.setPublishedAtComment(rs.getDate("m.published_at-message"));
                message.setPublishedAtComment(rs.getDate("c.published_at_comment"));
                message.setTextMessage(rs.getString("m.text"));
                message.setTextComment(rs.getString("c.text"));
                message.setUsernameComment(rs.getString("c.username"));
                message.setUsernameMessage(rs.getString("m.username"));
                messages.add(message);
            }
            return messages;
        }

       finally {
            if(rs!=null) rs.close();
        }
    }

}
