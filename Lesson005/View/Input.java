package Lesson005.View;

import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in, "Cp866");
    
    public Integer InputInt(){
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

    public Double inputDouble(){
        Double num;
        try
        {
            num = Double.parseDouble(scanner.next());
        }
        catch (Exception e)
        {
            num = null;
        }
        return num;
    }
}
