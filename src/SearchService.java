import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SearchService extends Writer {
    private ArrayList<Integer> container;
    private int numberToSearch;

    public SearchService() {

        super("searchResult.txt");
        container = new ArrayList<Integer>(Arrays.asList(21, 10, 2, 4, 1, 10, 5, 3));
    }

    public void begin() {
        System.out.println("Please type in the integer numbers to build input array");
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
        System.out.println("Please input the number to search");
        int numberToSearch;
        boolean legalInput = false;
        while (!legalInput) {
            try {
                this.numberToSearch = sc.nextInt();
                legalInput = true;
            } catch (NumberFormatException e) {
                System.out.println(e);
                System.out.println("Not a number");
                continue;

            }
        }
        System.out.println("The number to search is " + this.numberToSearch);
    }

    public void linearSearch() {
        ArrayList<Integer> searchDomain = this.container;
        int target = this.numberToSearch;
        boolean found = false;
        int foundIndex = -1;
        write("Array to search: " + convertListToString(searchDomain));
        write("Number to search: " + this.numberToSearch);
        for (int i = 0; i < searchDomain.size(); i++) {
            if (searchDomain.get(i) == target) {
                System.out.println(searchDomain.get(i));
                found = true;
                foundIndex = i;
                break;
            }
        }
        if (found) {
            System.out.println("Found it at index " + foundIndex);
            write("Result: " + "Found it at index " + foundIndex);
        } else {
            System.out.println("Not found");
            write("Result:" + "Not found");

        }
        closeFileWriter();
    }

    public void binarySearch() {
        Integer[] searchDomain = new Integer[this.container.size()];
        SortService sorter = new SortService();
        ArrayList<Integer>sortedContainer = sorter.bubbleSort(this.container);
        write("Array to search: " + sortedContainer);
        searchDomain=sortedContainer.toArray(searchDomain);
        write("Number to search: " + this.numberToSearch);
        int target = this.numberToSearch;
        boolean found = false;
        int foundIndex = -1;
        int lowerBound = 0;
        int upperBound = searchDomain.length - 1;

        while (!found) {
            int middleIndex = (upperBound + lowerBound) / 2;
            int middleVal = searchDomain[middleIndex];
            if (middleVal == target) {
                found = true;
                foundIndex = middleIndex;
                break;
            } else if (upperBound > lowerBound) {
                if (middleVal > target) {
                    upperBound = middleIndex - 1;
                    continue;

                } else {
                    lowerBound = middleIndex + 1;
                    continue;
                }
            } else {
                break;
            }
        }
        if (found) {
            System.out.println("Found it at index " + foundIndex);
            write("Result: " + "Found it at index " + foundIndex);
        } else {
            System.out.println("Not found");
            write("Result:" + "Not found");

        }
        closeFileWriter();
    }

}
