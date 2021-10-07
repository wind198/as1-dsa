import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadTextFileAndPrint {

    public static void readTextFileAndPrint() {
        ArrayList<Float> container = new ArrayList<Float>();
        String fileName = FileChooser.newChooser();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                container.add(Float.parseFloat(data));
            }
            myReader.close();
            if (container.size()>0){

                System.out.println("File content:");
                for (float item:container){
                    System.out.print(item + "\t");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
