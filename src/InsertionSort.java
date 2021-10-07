import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    private ArrayList<Integer> container;

    public InsertionSort() {
        container = new ArrayList<Integer>(Arrays.asList(21, 10, 2, 4, 1));
    }

    public void begin() {
        System.out.println("Please type in the integer numbers to sort");
        System.out.println("Type in each number one by one, press Enter after each number");

        System.out.println("Press 's' to finish.");

        Scanner sc = new Scanner(System.in);
        String answer = "";
        while (!answer.equals("s")) {
            try {
                answer = sc.nextLine();
                container.add(Integer.parseInt(answer));

            } catch (NumberFormatException e) {
                System.out.println(e);
                continue;
            }
        }
        insertionSort(container);
        System.out.println("sorting finish");
        Helper.printArray(container);
    }

    public void insertionSort(ArrayList<Integer> input) {
        ArrayList<Integer> output;
        int inputSize = input.size();
        for (int i = 1; i < inputSize; i++) {
            int targetElem = input.get(i);
            for (int j = 0; j < i; j++) {
                if (input.get(j) >= targetElem) {
                    if (j > 0) {
                        input.remove(i);
                        input.add(j, targetElem);
                    } else {
                        input.remove(i);
                        input.add(0, targetElem);

                    }
                    Helper.printArray(input);
                    break;
                }
            }

        }
    }
}
