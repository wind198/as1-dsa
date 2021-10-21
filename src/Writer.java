import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Writer {
    private FileWriter fileWriter;

    public Writer(String outputFileName) {
        try {
            String fileName = outputFileName;
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                System.out.println("Text container created: " + myObj.getName());
            } else {
                System.out.println("a text container already exists. File name is" + fileName);
            }
            fileWriter = new FileWriter(fileName, false);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            fileWriter = null;
        }
    }

    public void closeFileWriter() {
        try {
            this.fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred during closing file writer.");
            e.printStackTrace();
        }
    }

    public String convertListToString(ArrayList<Integer> input) {
        String str = "";
        for (Integer i : input) {
            str += i + " -- ";
        }
        return str;
    }

    public void write(String content) {
        try {

            this.fileWriter.write(content + "\n");
        } catch (IOException e) {
            System.out.println("An error occurred during closing file writer.");
            e.printStackTrace();
        }
    }
}
