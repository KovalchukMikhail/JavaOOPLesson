package HomeWork003.Items;

public class CurrentId {
    private static int currentId = 0;

    public static int getCurrentId() {
        return currentId++;
    }
}
