/**
 * Created by Yulya Telysheva
 */
package ru.kipolad.project;

import java.util.List;

public class TableRow {

    private final List<String> rowStings;

    public TableRow(List<String> rowStings) {
        this.rowStings = rowStings;
    }

    public List<String> getRowStings() {
        return rowStings;
    }
}
