/**
 * Created by Yulya Telysheva
 */
package ru.kipolad.project;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        PeopleRowsGenerator peopleRowsGenerator = new PeopleRowsGenerator(new RandomHumanGenerator());
        List<TableRow> rows = peopleRowsGenerator.generateRows(UserView.getNumberOfRows());
        Table table = new Table();
        table.createTable(rows);
    }
}
