package HomeWork004.DataBase.TestDb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MessageDb {
    private static String path = "HomeWork004/DataBase/TestDb/Message.txt";

    public static List<String> getMessagesData() {
        List<String> messages = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = "";
            while ((line = reader.readLine()) != null)
            {
                messages.add(line);
            }
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return messages;
    }

    public static void writeMessagesData(ArrayList<String> messagesDataList){
        try (FileWriter fw = new FileWriter(path, false))
        {
            for (String messageData : messagesDataList) {
                fw.write(messageData + "\n");
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
