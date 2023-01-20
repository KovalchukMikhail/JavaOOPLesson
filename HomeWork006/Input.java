package HomeWork006;
import java.util.Scanner;


public class Input {
    Scanner iScanner;

    public int inputInt(String text)
    {
        while (true) {
            System.out.println(text);
            iScanner = new Scanner(System.in);
            try
            {
                int result = iScanner.nextInt();
                return result;
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void scanerClose(){
        iScanner.close();
    }
}


// public class Input {
//     public static int inputInt(String text)
//     {
//         while(true)
//         {
//             System.out.println(text);
//             Scanner iScanner = new Scanner(System.in);
//             try
//             {
//                 int result = iScanner.nextInt();
//                 return result;
//             }
//             catch (Exception ex)
//             {
//                 System.out.println(ex.getMessage());
//             }
            
//         }
//     }
// }
