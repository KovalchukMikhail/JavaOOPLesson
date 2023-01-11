package HomeWork004.DataBase.TestDb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import HomeWork004.Model.Entities.User;


public class UserDb {
    private static String path = "HomeWork004/DataBase/TestDb/User.txt";

    public static ArrayList<String> getUsersData(){
        ArrayList<String> users = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = "";
            while ((line = reader.readLine()) != null)
            {
                users.add(line);
            }
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void writeUsersData(ArrayList<String> usersDataList){
        try (FileWriter fw = new FileWriter(path, false))
        {
            for (String userData : usersDataList) {
                fw.write(userData + "\n");
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }


}
