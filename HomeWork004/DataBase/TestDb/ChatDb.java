package HomeWork004.DataBase.TestDb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChatDb {
    private static String path = "HomeWork004/DataBase/TestDb/Chat.txt";

    public static List<String> getChatsData() {
        List<String> chats = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = "";
            while ((line = reader.readLine()) != null)
            {
                chats.add(line);
            }
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return chats;
    }

    public static void writeChatsData(ArrayList<String> chatsDataList){
        try (FileWriter fw = new FileWriter(path, false))
        {
            for (String chatData : chatsDataList) {
                fw.write(chatData + "\n");
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    
}