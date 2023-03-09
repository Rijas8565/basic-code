package com.project.pagination.page;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/page")
@RestController
public class PageController {
    @Autowired
    public PageService pageService;


    public PageRepository pageRepository;


    @RequestMapping(method = RequestMethod.POST,value = "/load")
    public ResponseEntity<Page> create(@RequestBody Page value){
        return new ResponseEntity(pageService.create(value), HttpStatus.CREATED);
    }
    @RequestMapping(method = RequestMethod.GET,value = "/display")
    public ResponseEntity<Page> get(@RequestParam Integer pagenumber,
                                    @RequestParam Integer pagesize,
                                    @RequestParam String order,
                                    @RequestParam String orderby){
        List<Page> list=pageService.get(pagenumber,pagesize,order,orderby);
        return new ResponseEntity(list,HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET,value = "/displaylist")
    public ResponseEntity<Page>get1(@RequestParam String fromdate,
                                    @RequestParam String todate){
        List<Page> list=pageService.get1(fromdate,todate);
        return new ResponseEntity(list,HttpStatus.OK);
    }


}
