package HomeWork004.Model.Entities;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private Integer chatId;
    List<User> users = new ArrayList<>();
    List<Message> messages = new ArrayList<>();
    private String chatName;
    public Chat(Integer chatId, List<User> users, String chatName) {
        this.chatId = chatId;
        this.chatName = chatName;
        this.users = users;
    }

    public void addUser(User user){
        if(!users.contains(user))users.add(user);     
    }

    public void addMessage(Message message){
        if(!messages.contains(message))messages.add(message); 
    }

    public ArrayList<Integer> getAllUsersId(){
        ArrayList<Integer> listId = new ArrayList<>(); 
        users.stream().forEach(u -> listId.add(u.getUserId()));
        return listId;
    }

    public void removeUserByUserId(Integer userId){
        users.removeIf(u -> u.getUserId().equals(userId));
    }

    public ArrayList<Integer> getAllMessagesId(){
        ArrayList<Integer> listId = new ArrayList<>(); 
        messages.stream().forEach(m -> listId.add(m.getMessageId()));
        return listId;
    }

    public void removeMessageByMessageId(Integer messageId){
        messages.removeIf(m -> m.getMessageId().equals(messageId));
    }

    public Integer getChatId() {
        return chatId;
    }
    public String getChatName() {
        return chatName;
    }
    public void setChatName(String chatName) {
        this.chatName = chatName;
    }
    public String getUsersIdString(){
        String result = "";
        for (User user : users) {
            result += user.getUserId() + " ";
        }
        return result.trim();
    }

    public List<Message> getMessages() {
        return messages;
    }

    @Override
    public String toString() {
        return this.chatId + ":" + this.chatName + ":" + this.users.toString();
    }

}
