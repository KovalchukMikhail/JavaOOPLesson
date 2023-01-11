package HomeWork004.DataBase.TestDb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import HomeWork004.Model.Entities.Chat;
import HomeWork004.Model.Entities.Message;
import HomeWork004.Model.Entities.User;

public class InitializerDb {
    List <User> users = new ArrayList<>();
    List <Chat> chats = new ArrayList<>();
    List <Message> messages = new ArrayList<>();

    public InitializerDb() {
        this.users = getUsersFromDb();
        this.chats = getChatsFromDb();
        this.messages = getMessagesFromDb();
    }

    public List<Chat> getAllChats() {
        return this.chats;
    }

    public List<User> getAllUsers() {
        return this.users;
    }

    public void addUserToDb(User user, String password){
        this.users.add(user);
        ArrayList <String> usersDataList = new ArrayList<>();
        for (User u : users) {
            String str = u.getUserId() + ":" + u.getUserName() + ":" + u.getUserPassword();
            usersDataList.add(str);
        }
        UserDb.writeUsersData(usersDataList);
    }

    public void addChatToDb(Chat chat){
        this.chats.add(chat);
        ArrayList <String> chatsDataList = new ArrayList<>();
        for (Chat c : chats) {
            String str = c.getChatId() + ":" + c.getUsersIdString() + ":" + c.getChatName();
            chatsDataList.add(str);
        }
        ChatDb.writeChatsData(chatsDataList);
    }

    public void addMessageToDb(Message message){
        this.messages.add(message);
        ArrayList <String> messagesDataList = new ArrayList<>();
        for (Message m : messages) {
            String str = m.getMessageId() + ":" + m.getUserId() + ":" + m.getChatId() + ":" + m.getText();
            messagesDataList.add(str);
        }
        MessageDb.writeMessagesData(messagesDataList);
    }

    public User getUserById(Integer id){
        Optional <User> entity =  this.users.stream().filter(u -> u.getUserId().equals(id)).findFirst();
        if(!entity.isEmpty()) return entity.get();
        return null;
    }
    public User getUserByName(String name){
        Optional <User> entity =  this.users.stream().filter(u -> u.getUserName().equals(name)).findFirst();
        if(!entity.isEmpty()) return entity.get();
        return null;
    }
    

    public Chat getChatById(Integer id){
        Optional <Chat> entity =  this.chats.stream().filter(c -> c.getChatId().equals(id)).findFirst();
        if(!entity.isEmpty()) return entity.get();
        return null;
    }

    public List <User> getUsersFromDb(){
        List <User> users = new ArrayList<>();
        List <String> usersDataList = UserDb.getUsersData();
        usersDataList.stream().forEach(c -> users.add(new User(Integer.valueOf(c.split(":")[0]), c.split(":")[1], c.split(":")[2])));
        return users;
    }

    public List <Chat> getChatsFromDb(){
        List <Chat> chats = new ArrayList<>();
        List <String> chatsDataList = ChatDb.getChatsData();
        for (String chatData : chatsDataList) {
            List<String> data = Arrays.asList(chatData.split(":"));
            Integer chatId = Integer.valueOf(data.get(0));
            List<User> users = new ArrayList<>();
            for (String id : Arrays.asList(data.get(1).split(" "))) {
                User user = getUserById(Integer.valueOf(id));
                users.add(user);
                user.addChatId(chatId);
            }
            String chatName = data.get(2);
            chats.add(new Chat(chatId, users, chatName));
        }
        return chats;
    }

    public List <Message> getMessagesFromDb(){
        List <Message> messages = new ArrayList<>();
        List <String> messagesDataList = MessageDb.getMessagesData();
        for (String messageData : messagesDataList) {
            List<String> data = Arrays.asList(messageData.split(":"));
            Integer messageId = Integer.valueOf(data.get(0));
            User user = getUserById(Integer.valueOf(data.get(1)));
            Chat chat = getChatById(Integer.valueOf(data.get(2)));
            String text = data.get(3);
            Message message = new Message(messageId, user, chat, text);
            chat.addMessage(message);
            messages.add(message);
        }
        return messages;
    }

    public Integer getMaxUserId(){
        Integer maxId = 0;
        List <String> usersDataList = UserDb.getUsersData();
        for (String userData : usersDataList) {
            Integer temp = Integer.valueOf(userData.split(":")[0]);
            if(temp > maxId) maxId = temp;
        }
        return maxId;
    }

    public void setChatDb(Chat chat){
        for (int i = 0; i < chats.size(); i++) {
            if (chats.get(i).getChatId().equals(chat.getChatId())){
                chats.set(i, chat);
                ArrayList <String> chatsDataList = new ArrayList<>();
                for (Chat c : chats) {
                    String str = c.getChatId() + ":" + c.getUsersIdString() + ":" + c.getChatName();
                    chatsDataList.add(str);
                }
                ChatDb.writeChatsData(chatsDataList);
            }
        }
    }

    public Integer getMaxChatId(){
        Integer maxId = 0;
        List <String> chatsDataList = ChatDb.getChatsData();
        for (String chatData : chatsDataList) {
            Integer temp = Integer.valueOf(chatData.split(":")[0]);
            if(temp > maxId) maxId = temp;
        }
        return maxId;
    }

    public Integer getMaxMessageId(){
        Integer maxId = 0;
        List <String> messagesDataList = MessageDb.getMessagesData();
        for (String messageData : messagesDataList) {
            Integer temp = Integer.valueOf(messageData.split(":")[0]);
            if(temp > maxId) maxId = temp;
        }
        return maxId;
    }
}
