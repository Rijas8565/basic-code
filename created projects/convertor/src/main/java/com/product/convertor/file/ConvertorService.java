package com.product.convertor.file;

import com.lowagie.text.DocumentException;
import com.product.convertor.exception.CustomException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


@AllArgsConstructor
@NoArgsConstructor
@Component
@Service
public class ConvertorService {

    @Autowired
    public ConvertorRepository convertorRepository;

    public CustomException customException;

    @Autowired
    public Pdfexport pdfexport;
    @Autowired
    public XlsExport xlsExport;
    @Autowired
    public XlsxExport xlsxExport;
    @Autowired
    public CsvExport csvExport;

    Environment ev;

    public Convertor create(Convertor value){
       Integer score=value.getScore();
        if(score>100) {
           throw new CustomException("number should be less than 100", HttpStatus.UNPROCESSABLE_ENTITY);
       }
       return convertorRepository.save(value);
    }

    public List<Convertor> get() {
        List<Convertor> file = convertorRepository.findAll();
        return file;
    }

    public String date(){
        SimpleDateFormat dt= new SimpleDateFormat("ddMMyyyy_HHmmss");
        String date1=dt.format(new Date());
        return date1;
    }
    @Value("${path.pdf}")
    public String pdfPath;

    @Value("${path.xls}")
    public String xlsPath;

    @Value("${path.xlsx}")
    public String xlsxPath;

    @Value("${path.csv}")
    public String csvPath;

    //for pdf export
    public String convertionpdf() throws IOException, DocumentException {
        List<Convertor> list=convertorRepository.findAll();
        pdfexport.listToPdf(list,pdfPath+date()+".pdf");
        return "success";
      }

    //for xls export
    public String convertionxls() throws IOException{
        List<Convertor> list=convertorRepository.findAll();
        xlsExport.listToXls(list,xlsPath+date()+".xls");
        return "success";
    }

    //for xlsx export
    public String convertionxlsx() throws IOException{
        List<Convertor> list=convertorRepository.findAll();
        xlsxExport.listToXlsx(list,xlsxPath+date()+".xlsx");
        return "success";
    }

    //for csv export
    public String convertioncsv() throws IOException {
        List<Convertor> list=convertorRepository.findAll();
        csvExport.listToCsv(list,csvPath+date()+".csv");
        return "success";
    }
    }

