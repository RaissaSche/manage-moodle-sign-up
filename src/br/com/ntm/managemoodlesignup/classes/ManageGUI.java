package br.com.ntm.managemoodlesignup.classes;

import javax.swing.*;
import java.io.File;

public class ManageGUI {

    private boolean showSelectPrompt = true;
    private ManageFile manageFile = new ManageFile();
    private File file;

    public void manageGUI() {

        JFileChooser fileChooser = new JFileChooser();

        while (showSelectPrompt) {

            int answer = fileChooser.showOpenDialog(null);

            if (answer == JFileChooser.CANCEL_OPTION) {
                showSelectPrompt = false;
                System.exit(0);
            }

            if (answer == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();

                try {
                    manageFile.checkIfFileIsTSV(file.getAbsolutePath());
                    showSelectPrompt = false;

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(fileChooser,
                            e.getMessage(),
                            "Aviso!",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        String courseInitials = JOptionPane.showInputDialog("Nome breve do curso:");
        manageFile.readAndWriteFile(file.getAbsolutePath(), courseInitials);

        JOptionPane.showMessageDialog(fileChooser,
                "Feito! O novo arquivo está na mesma pasta que o que você inseriu!",
                "Pronto!",
                JOptionPane.INFORMATION_MESSAGE);
    }
}

