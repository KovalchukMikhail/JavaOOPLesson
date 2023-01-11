package HomeWork004.Model.Entities;

public class Message {
    private Integer messageId;
    private Integer userId;
    private Integer chatId;
    private String text;

    public Message(Integer messageId, User user, Chat chat, String text) {
        this.messageId = messageId;
        this.chatId = chat.getChatId();
        this.userId = user.getUserId();        
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getChatId() {
        return chatId;
    }


    public Integer getUserId() {
        return userId;
    }

    public Integer getMessageId() {
        return messageId;
    }
    @Override
    public String toString() {
        return String.format("messageId:%d,userId:%d,chatId:%d,text:%s", this.messageId, this.userId, this.chatId, this.text);
    }
}
