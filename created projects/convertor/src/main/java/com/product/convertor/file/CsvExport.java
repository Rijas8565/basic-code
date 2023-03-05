package com.product.convertor.file;



import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;


import java.io.*;
import java.util.ArrayList;
import java.util.List;



@Component
public class CsvExport {
    public CsvExport() {
    }

    public void listToCsv(List<Convertor> list, String filePath) throws IOException {
        List<Convertor> file1=list.stream().toList();
        File file = new File(filePath);
        FileWriter fw = new FileWriter(file);
        CSVPrinter printer = new CSVPrinter(fw, CSVFormat.DEFAULT);

        for (Convertor object : file1) {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(object.getId()));
            row.add(object.getName());
            row.add(object.getRegisternumber());
            row.add(String.valueOf(object.getDob()));
            row.add(String.valueOf(object.getStatus()));
            row.add(String.valueOf(object.getScore()));
            row.add(object.getEmail());
            printer.printRecord(row);
        }
        printer.close();
       }
}
