package ClassWork001.Task002;

public class Controller {
    public static void run(){
        int count = 3;
        int[] array = View.data();
        View.showArray(array);
        if (Model.check(array, count)){
            int[] result = Model.getSum(array, count);
            // View.showArray(result);
            View.showResult(result);
        }
        else{
            View.showError();
        }
        
    }
}
