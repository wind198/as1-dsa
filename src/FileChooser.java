import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class FileChooser extends JFrame {
    // Jlabel to show the files user selects

    private static String filePicked;

    public static String newChooser() {
        JFileChooser j = new JFileChooser("D:\\DATA\\SOFTWARE_SELF_TRAINING\\FUNIX_COURSES\\dsa\\CSD201x_02-A_VN_DN_Assignment_3_tuanlhfx10549@funix.edu.vn");

        // set the selection mode to directories only
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);


        int r = j.showOpenDialog(null);

        if (r == JFileChooser.APPROVE_OPTION) {
            // set the label to the path of the selected directory
            filePicked = j.getSelectedFile().getAbsolutePath();

        }
        // if the user cancelled the operation
        else
            System.out.println("the user cancelled the operation");
        return filePicked;
    }
}