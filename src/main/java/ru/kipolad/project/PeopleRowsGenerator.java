/**
 * Created by Yulya Telysheva
 */
package ru.kipolad.project;

import java.util.ArrayList;
import java.util.List;
public class PeopleRowsGenerator {
    private final RandomHumanGenerator randomHumanGenerator;

    public PeopleRowsGenerator(RandomHumanGenerator randomHumanGenerator) {
        this.randomHumanGenerator = randomHumanGenerator;
    }

    public List<TableRow> generateRows(int rowCount) {
        List<TableRow> rows = new ArrayList<>();
        for(int i = 0; i < rowCount; i++) {
            rows.add(randomHumanGenerator.getRandomHuman());
        }
        return rows;
    }
}
