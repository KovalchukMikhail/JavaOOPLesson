package HomeWork004.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import HomeWork004.DataBase.TestDb.InitializerDb;
import HomeWork004.Model.Entities.Chat;
import HomeWork004.Model.Entities.Message;
import HomeWork004.Model.Entities.User;

public class Infrastructure {
    InitializerDb db;
    public Infrastructure(InitializerDb db) {
        this.db = db;
    }

    public User createUser(String userName, String password){
        User user = new User (db.getMaxUserId() + 1, userName, password);
        db.addUserToDb(user, password);
        return user;
    }

    public Message createMessage(User user, Chat chat, String text){
        Message message = new Message (db.getMaxMessageId() + 1, user, chat, text);
        db.addMessageToDb(message);
        chat.addMessage(message);
        return message;
    }

    public User selectUser(String userName){
        Optional<User> entities = db.getAllUsers().stream().filter(u -> u.getUserName().toLowerCase().equals(userName)).findFirst();
        if (entities.isEmpty()) return null;
        return entities.get();
    }

    public String getInfoAllChatsOfUser(User user){
        String chatsInfo = "";
        for (Integer chatId : user.getChatsId()) {
            Chat chat = db.getChatById(chatId);
            if(chat != null){
                chatsInfo = "chatId - " + chat.toString() + "\n" + chatsInfo;
            }
        }
        
        return "Список чатов:\n" + chatsInfo;
    }

    public String getAllMessagesFromChat(Chat chat){
        String text = "";
        for (Message message : chat.getMessages()) {
            text += message.getText() + "\n";
        }
        return text;
    }


    public Chat createChat(User user){
        Integer chatId = db.getMaxChatId() + 1;
        String chatName = "Chat#" + chatId;
        List <User> users = new ArrayList<>();
        users.add(user);
        Chat chat = new Chat(chatId, users, chatName);
        db.addChatToDb(chat);
        return chat;
    }



}
