import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReceiveInputAndStoreService {
    public static void receiveInputAndStore() {
        System.out.println("Please type in a real number, press Enter to finish");
        Scanner sc = new Scanner(System.in);
        Float answer = sc.nextFloat();
        String fileName = createFile();
        writeToFile(fileName, Float.toString(answer));
    }
    public static void writeToFile(String fileName, String content) {
        try {
            FileWriter myWriter = new FileWriter(fileName, false);
            myWriter.write(content+"\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static String createFile() {
        try {
            String fileName = "textContainer.txt";
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                System.out.println("Text container created: " + myObj.getName());
            } else {
                System.out.println("a text container already exists. File name is" + fileName);
            }
            return fileName;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
}
