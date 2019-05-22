package br.com.ntm.managemoodlesignup.classes;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class ManageGUI {

    ManageFile manageFile = new ManageFile();

    public void manageGUI() {

        JFileChooser fileChooser = new JFileChooser();
        int answer = fileChooser.showOpenDialog(null);

        if (answer == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println(file.getAbsolutePath());
            manageFile.readAndWriteFile(file.getAbsolutePath());
        } else {
            // dialogo cancelado
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
