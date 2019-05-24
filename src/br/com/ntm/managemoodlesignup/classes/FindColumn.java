package br.com.ntm.managemoodlesignup.classes;

import br.com.ntm.managemoodlesignup.exceptions.ColumnNotFoundException;
import br.com.ntm.managemoodlesignup.exceptions.EmailNotFoundException;

import java.util.ArrayList;
import java.util.List;

class FindColumn {

    List<String> findEmail(List<List<String>> spreadsheetInfo) {

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

    List<String> findName(List<List<String>> spreadsheetInfo) {

        List<String> firstRow = spreadsheetInfo.get(0);

        for (int i = 0; i < firstRow.size(); i++) {

            if (firstRow.get(i).toLowerCase().contains("nome")) {

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
