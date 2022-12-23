package HomeWork003.Model;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;

public class Model {
    public static void saveFile(String text, String path )
    {
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (Exception e) {
        }

        try (FileWriter fw = new FileWriter(path, false))
        {
            fw.write(text);
            fw.close();
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
