/**
 * Created by Yulya Telysheva
 */
package ru.kipolad.project;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.Stream;

public class Table {

    private final PdfPTable table = new PdfPTable(14);
    private final String fileName = "GenerationTable.pdf";
    private final Document document = new Document(PageSize.A4.rotate());
    private static final String FONT = "src/main/resources/arial.ttf";

    public void createTable(java.util.List<TableRow> rows) {
        document.setMargins(0, 0, 20, 20);
        try {
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
        document.open();

        this.addHeaders(setFont());
        this.fillRows(setFont(), rows);

        try {
            document.add(table);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        getFilePath();
    }

    private Font setFont() {
        BaseFont baseFont = null;
        try {
            baseFont = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
        return new Font(baseFont, 7, Font.NORMAL);
    }

    private void fillRows(Font font, java.util.List<TableRow> rows) {
        rows.forEach(tableRow -> tableRow.getRowStings().forEach(columnTitle -> {
            PdfPCell cell = new PdfPCell();
            cell.setPhrase(new Phrase(columnTitle, font));
            table.addCell(cell);
        })
        );
    }

    private void addHeaders(Font font) {
        Stream.of("Имя", "Фамилия", "Отчество", "Возраст", "Пол", "Дата рождения", "Место рождения", "Индекс", "Страна",
                "Область", "Город", "Улица", "Дом", "Квартира").forEach(columnTitle -> {
            PdfPCell header = new PdfPCell();
            header.setPhrase(new Phrase(columnTitle, font));
            header.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(header);
        });
    }

    private void getFilePath() {
        File file = new File(fileName);
        System.out.println("Файл создан. Путь: " + file.getAbsolutePath());
    }
}
