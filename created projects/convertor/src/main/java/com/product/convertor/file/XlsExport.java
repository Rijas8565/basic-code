package com.product.convertor.file;

import org.springframework.stereotype.Component;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class XlsExport {
    public XlsExport() {
    }

    public void listToXls(List<Convertor> list, String filePath) throws IOException {

        List<Convertor> file=list.stream().collect(Collectors.toList());
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");
        Integer rownum=0;
        Row row = sheet.createRow(rownum);

        Cell cell = row.createCell(0);
        cell.setCellValue("ID");

        cell = row.createCell(1);
        cell.setCellValue("NAME");

        cell = row.createCell(2);
        cell.setCellValue("REG NUMBER");

        cell = row.createCell(3);
        cell.setCellValue("DOB");

        cell = row.createCell(4);
        cell.setCellValue("STATUS");

        cell = row.createCell(5);
        cell.setCellValue("SCORE");

        cell = row.createCell(6);
        cell.setCellValue("EMAIL");


        for (int i = 0; i < file.size(); i++) {

            row = sheet.createRow(i + 1);
            Convertor object = file.get(i);

            cell = row.createCell(0);
            cell.setCellValue(object.getId());

            cell = row.createCell(1);
            cell.setCellValue(object.getName());

            cell = row.createCell(2);
            cell.setCellValue(object.getRegisternumber());

            cell = row.createCell(3);
            cell.setCellValue(object.getDob());
            CellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(workbook.getCreationHelper().createDataFormat().getFormat("dd/mm/yyyy"));
            cell.setCellStyle(dateCellStyle);

            cell = row.createCell(4);
            cell.setCellValue(object.getStatus());

            cell = row.createCell(5);
            cell.setCellValue(object.getScore());

            cell = row.createCell(6);
            cell.setCellValue(object.getEmail());
        }


        FileOutputStream fileOut = new FileOutputStream(filePath);
        workbook.write(fileOut);
        fileOut.close();


        workbook.close();

    }
}
