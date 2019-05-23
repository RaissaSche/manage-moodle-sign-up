package br.com.ntm.managemoodlesignup.classes;

import javax.swing.*;
import java.io.File;

public class ManageGUI {

    ManageFile manageFile = new ManageFile();

    public void manageGUI() {

        JFileChooser fileChooser = new JFileChooser();
        int answer = fileChooser.showOpenDialog(null);

        if (answer == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try {
                manageFile.checkIfFileIsTSV(file.getAbsolutePath());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(fileChooser,
                        e.getMessage(),
                        "Aviso!",
                        JOptionPane.WARNING_MESSAGE);
            }

            String courseInitials = JOptionPane.showInputDialog("Nome breve do curso:");
            manageFile.readAndWriteFile(file.getAbsolutePath(), courseInitials);

            JOptionPane.showMessageDialog(fileChooser,
                    "Feito! O novo arquivo está na mesma pasta que o que você inseriu!",
                    "Pronto!",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
