import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class AllServices {
    //print out a menu of services to serve
    public static void main(String args[]) {
        begin();
    }

    public static void begin() {
        Scanner sc = new Scanner(System.in);
        boolean restart = true;
        do {
            System.out.println("""
                    This program provide the following functionalities
                    Function 1. Type in a real number, we shall store it in a text file.
                    Function 2. We read a text file and print the content to console.
                    Function 3. Sort an array using Bubble sort.
                    Function 4: Sort an array using Selection sort.
                    Function 5. Sort an array using Insertion sort.
                    Function 6: Search an array using linear Search. 
                    Function 7: Search an array using binary Search. 
                    """);
            System.out.println("Which function do you want to choose");
            int answer = sc.nextInt();

            if (answer < 1 || answer > 7) {
                restart = true;
                continue;
            }
            ;

            switch (answer) {

                case 1:
                    ReceiveInputAndStoreService.receiveInputAndStore();
                    break;
                case 2:
                    ReadTextFileAndPrint.readTextFileAndPrint();
                    break;
                case 3:
                    SortService bubbleSorter = new SortService();
                    bubbleSorter.begin();
                    bubbleSorter.bubbleSort(bubbleSorter.getContainer());
                    break;
                case 4:
                    SortService selectionSorter = new SortService();
                    selectionSorter.begin();
                    selectionSorter.selectionSort(selectionSorter.getContainer());
                    break;
                case 5:
                    SortService insertionSorter = new SortService();
                    insertionSorter.begin();
                    insertionSorter.insertionSort(insertionSorter.getContainer());
                    break;
//
                case 6:
                    SearchService linearSearcher = new SearchService();
                    linearSearcher.begin();
                    linearSearcher.linearSearch();
                    break;
                case 7:
                    SearchService binarySearcher = new SearchService();
                    binarySearcher.begin();
                    binarySearcher.binarySearch();
                    break;

            }
            System.out.println("Do you want to continue, type 1 to continue and 2 to stop");
            answer = sc.nextInt();
            if (answer != 1) {
                restart = false;
            }
        } while (restart);


    }

    //    receiveInputAndStore();


    //    readTextFileAndPrint();

//    bubbleSort();
//    selectionSort();
//    insertionSort();
//    linearSearch()
//    binarySearch();







}
