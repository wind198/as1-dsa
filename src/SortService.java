import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SortService  extends  Writer{
    private ArrayList<Integer> container;

    public SortService() {
        super("sortProgress.txt");
        container = new ArrayList<Integer>(Arrays.asList(21, 10, 2, 4, 1));
    }

    public ArrayList<Integer> getContainer() {
        return container;
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
        System.out.println("The initial array is: " + this.container);
    }

    public ArrayList<Integer> bubbleSort(ArrayList<Integer> input) {
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (Integer i : input) {
            output.add(i);
        }
        int ouputSize = output.size();
        int swapCounter;
         write(convertListToString(output));
        do {
            swapCounter = 0;
            System.out.println("New round");
            for (int j = 0; j < ouputSize - 1; j++) {
                if (output.get(j) > output.get(j + 1)) {
                    Helper.swap(output, j, j + 1);
                    swapCounter++;
                    Helper.printArray(output);
                    write(convertListToString(output));
                }
            }
        } while (swapCounter > 0);
        System.out.println("Finish!");
        Helper.printArray(output);
        closeFileWriter();
        return output;
    }

    public ArrayList<Integer> selectionSort(ArrayList<Integer> input) {
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (Integer i : input) {
            output.add(i);
        }
        int outputSize = output.size();
        write(convertListToString(output));
        for (int i = 0; i < outputSize - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < outputSize; j++) {
                if (output.get(j) < output.get(minIndex)) {
                    minIndex = j;
                }

            }
            int minVal = output.get(minIndex);
            output.remove(minIndex);
            output.add(i, minVal);
            Helper.printArray(output);
             write(convertListToString(output));
        }
        System.out.println("finish!");
        Helper.printArray(output);
        closeFileWriter();
        return output;
    }

    public ArrayList<Integer> insertionSort(ArrayList<Integer> input) {
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (Integer i : input) {
            output.add(i);
        }
        int outputSize = output.size();
        write(convertListToString(output));
        for (int i = 1; i < outputSize; i++) {
            int targetElem = output.get(i);
            for (int j = 0; j < i; j++) {
                if (output.get(j) >= targetElem) {
                    if (j > 0) {
                        output.remove(i);
                        output.add(j, targetElem);
                    } else {
                        output.remove(i);
                        output.add(0, targetElem);
                    }
                    Helper.printArray(output);
                    write(convertListToString(output));
                    break;
                }
            }

        }
        closeFileWriter();
        return output;
    }


}
