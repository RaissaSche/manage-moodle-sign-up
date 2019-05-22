package br.com.ntm.managemoodlesignup.classes;

import br.com.ntm.managemoodlesignup.exceptions.ColumnNotFoundException;
import br.com.ntm.managemoodlesignup.exceptions.EmailNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class FindColumn {

    public List<String> findEmail(List<List<String>> spreadsheetInfo) {

        List<String> firstRow = spreadsheetInfo.get(0);

        for (int i = 0; i < firstRow.size(); i++) {

            if (firstRow.get(i).toLowerCase().contains("email")
                    || firstRow.get(i).toLowerCase().contains("e-mail")) {

                List<String> emailColumn = new ArrayList<>();

                for (List<String> info : spreadsheetInfo) {
                    emailColumn.add(info.get(i));
                }

                return emailColumn;
            }
        }

        throw new EmailNotFoundException();
    }

    public List<String> find(String columnName, List<List<String>> spreadsheetInfo) {
        //columnName variable must be lower-case

        List<String> firstRow = spreadsheetInfo.get(0);

        for (int i = 0; i < firstRow.size(); i++) {

            if (firstRow.get(i).toLowerCase().contains(columnName)) {

                List<String> nameColumn = new ArrayList<>();

                for (List<String> info : spreadsheetInfo) {
                    nameColumn.add(info.get(i));
                }

                return nameColumn;
            }
        }
        throw new ColumnNotFoundException();
    }
}
