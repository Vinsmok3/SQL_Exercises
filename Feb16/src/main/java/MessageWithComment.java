import java.util.Date;

public class MessageWithComment {

    private Long idMessage;
    private String textMessage;
    private Date publishedAtMessage;
    private  String usernameMessage;

    private Long idComment;
    private String textComment;
    private Date publishedAtComment;
    private  String usernameComment;

    public Long getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Long idMessage) {
        this.idMessage = idMessage;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public Date getPublishedAtMessage() {
        return publishedAtMessage;
    }

    public void setPublishedAtMessage(Date publishedAtMessage) {
        this.publishedAtMessage = publishedAtMessage;
    }

    public String getUsernameMessage() {
        return usernameMessage;
    }

    public void setUsernameMessage(String usernameMessage) {
        this.usernameMessage = usernameMessage;
    }

    public Long getIdComment() {
        return idComment;
    }

    public void setIdComment(Long idComment) {
        this.idComment = idComment;
    }

    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    public Date getPublishedAtComment() {
        return publishedAtComment;
    }

    public void setPublishedAtComment(Date publishedAtComment) {
        this.publishedAtComment = publishedAtComment;
    }

    public String getUsernameComment() {
        return usernameComment;
    }

    public void setUsernameComment(String usernameComment) {
        this.usernameComment = usernameComment;
    }

    @Override
    public String toString() {
        return "MessageWithComment{" +
                "idMessage=" + idMessage +
                ", textMessage='" + textMessage + '\'' +
                ", publishedAtMessage=" + publishedAtMessage +
                ", usernameMessage='" + usernameMessage + '\'' +
                ", idComment=" + idComment +
                ", textComment='" + textComment + '\'' +
                ", publishedAtComment=" + publishedAtComment +
                ", usernameComment='" + usernameComment + '\'' +
                '}';
    }
}
