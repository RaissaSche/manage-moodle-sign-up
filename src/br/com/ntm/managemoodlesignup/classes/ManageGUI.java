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
                System.out.println("I caught: " + e);
                JOptionPane.showMessageDialog(fileChooser,
                        e.getMessage(),
                        "Aviso!",
                        JOptionPane.WARNING_MESSAGE);
            }

            String courseInitials = JOptionPane.showInputDialog("Nome breve do curso:");
            manageFile.readAndWriteFile(file.getAbsolutePath(), courseInitials);
        }

    }
}

      /*  JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("tsv"));
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION)
           return;
        File file = chooser.getSelectedFile();
        if (!file.getAbsolutePath().endsWith(".png"))
           file = new File(file.getAbsolutePath() + ".png");*/
