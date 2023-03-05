package com.product.convertor.file;


import com.lowagie.text.DocumentException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/convertor")
@RestController
public class ConvertorController {

    public ConvertorService convertorService;
    public ConvertorRepository convertorRepository;



    @RequestMapping(method = RequestMethod.POST,value = "/load")
    public ResponseEntity<Convertor> create(@RequestBody Convertor value){
        return new ResponseEntity(convertorService.create(value),HttpStatus.CREATED);
    }
    @RequestMapping(method = RequestMethod.GET,value = "/display")
    public ResponseEntity<Convertor> get(){
        return new ResponseEntity(convertorService.get(),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> get1(@RequestParam String download) throws IOException, DocumentException {

        if(download.equals("pdf")){
            return ResponseEntity.ok(convertorService.convertionpdf());
        } else if (download.equals("xls")) {
            return ResponseEntity.ok(convertorService.convertionxls());
        } else if (download.equals("xlsx")) {
            return ResponseEntity.ok(convertorService.convertionxlsx());
        }else {
            return ResponseEntity.ok(convertorService.convertioncsv());
        }
    }

    /*
    @RequestMapping(method = RequestMethod.GET,value = "/download/pdf")
    public ResponseEntity<String> get1() throws IOException, DocumentException {
        return ResponseEntity.ok(convertorService.convertionpdf());
    }

    @RequestMapping(method = RequestMethod.GET,value = "/download/xls")
    public ResponseEntity<String> get2() throws IOException {
        return ResponseEntity.ok(convertorService.convertionxls());
    }

    @RequestMapping(method = RequestMethod.GET,value = "/download/xlsx")
    public ResponseEntity<String> get3() throws IOException {
        return ResponseEntity.ok(convertorService.convertionxlsx());
    }

    @RequestMapping(method = RequestMethod.GET,value = "/download/csv")
    public ResponseEntity<String> get4() throws IOException {
        return ResponseEntity.ok(convertorService.convertioncsv());
    }*/
}
