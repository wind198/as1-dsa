import java.util.ArrayList;

public class Helper {
    public static void swap(ArrayList<Integer> arr, int index1, int index2) {
        int temp = arr.get(index1);
        arr.set(index1, arr.get(index2));
        arr.set(index2, temp);
    }

    public static void printArray(ArrayList<Integer> input) {
        if (input.size() > 0) {
            for (int i : input) {
                System.out.print(i + " -- ");
            }
            System.out.print("\n");
        } else {
            System.out.println("Array is empty!");

        }
    }
}
