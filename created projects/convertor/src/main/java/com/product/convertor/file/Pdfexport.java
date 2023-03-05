package com.product.convertor.file;


import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import org.springframework.stereotype.Component;


import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Pdfexport {

    public Pdfexport() {
    }

    public void listToPdf(List<Convertor> list, String filePath) throws IOException, DocumentException {
        List<Convertor> l1= list.stream().collect(Collectors.toList());
        Document document = new Document(PageSize.A4, 25, 25, 25, 25);
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        PdfPCell pdfPCell=new PdfPCell();
        PdfPTable table=new PdfPTable(7);
        pdfPCell.setPadding(5);
        pdfPCell.setBackgroundColor(Color.cyan);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{1.2f,2.0f,2.8f,2.5f,2.0f,1.5f,3.5f});
        pdfPCell.setPhrase(new Phrase("ID"));
        table.addCell(pdfPCell);
        pdfPCell.setPhrase(new Phrase("NAME"));
        table.addCell(pdfPCell);
        pdfPCell.setPhrase(new Phrase("REGISTER NUMBER"));
        table.addCell(pdfPCell);
        pdfPCell.setPhrase(new Phrase("DOB"));
        table.addCell(pdfPCell);
        pdfPCell.setPhrase(new Phrase("STATUS"));
        table.addCell(pdfPCell);
        pdfPCell.setPhrase(new Phrase("SCORE"));
        table.addCell(pdfPCell);
        pdfPCell.setPhrase(new Phrase("EMAIL"));
        table.addCell(pdfPCell);

        for (Convertor object:list){
            table.addCell(String.valueOf(object.getId()));
            table.addCell(String.valueOf(object.getName()));
            table.addCell(String.valueOf(object.getRegisternumber()));
            table.addCell(String.valueOf(object.getDob()));
            table.addCell(String.valueOf(object.getStatus()));
            table.addCell(String.valueOf(object.getScore()));
            table.addCell(String.valueOf(object.getEmail()));
        }
         document.add(table);
         document.close();
    }
}
