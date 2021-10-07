import java.sql.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    private ArrayList<Integer> container;

    public BubbleSort() {
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
        bubbleSort(container);

    }

    public void bubbleSort(ArrayList<Integer> input) {
        ArrayList<Integer> output;
        int inputSize = input.size();
        int swapCounter;
        do {
            swapCounter = 0;
            System.out.println("New round");
            for (int j = 0; j < inputSize - 1; j++) {
                if (input.get(j) > input.get(j + 1)) {
                    Helper.swap(input, j, j + 1);
                    swapCounter++;
                    Helper.printArray(input);
                }
            }
        } while (swapCounter > 0);
        System.out.println("Finish!");
        Helper.printArray(input);
    }


}
