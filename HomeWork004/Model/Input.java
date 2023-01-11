package HomeWork004.Model;

import java.util.Scanner;

public class Input {
    public String inputString(Scanner scanner){
        String result = "";
        try
        {
            result = scanner.next(); 
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public String inputStringLine(Scanner scanner){
        String result = "";
        try
        {
            result = scanner.nextLine(); 
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public Integer inputInt(Scanner scanner){
        Integer num;
        try
        {
            num = Integer.valueOf(scanner.next());
        }
        catch (Exception e)
        {
            num = null;
        }
        return num;
    }
}
