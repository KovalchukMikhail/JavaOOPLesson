package HomeWork004.Model.Entities;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Integer userId;
    private String userName;
    private String userPassword;
    private List<Integer> chatsId = new ArrayList<>();

    public User(Integer userId, String userName, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }
    

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean setUserPassword(String userPasswordOld, String userPasswordNew) {
        if(checkPassword(userPasswordOld))
        {
            this.userPassword = userPasswordNew;    
            return true;
        }
        return false;    
    }

    public boolean checkPassword(String password){
        if(this.userPassword.equals(password))return true;
        return false;
    }

    public String getUserPassword() {
        return userPassword;
    }
    
    public List<Integer> getChatsId() {
        return chatsId;
    }
    
    public void addChatId(Integer chatId){
        this.chatsId.add(chatId);
    }

    @Override
    public String toString() {
        return String.format("userId:%d,userName:%s", userId, userName);
    }

    
}
