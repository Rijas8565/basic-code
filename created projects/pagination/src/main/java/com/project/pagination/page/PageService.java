package com.project.pagination.page;


import com.project.pagination.exception.CustomException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Component
@Service
public class PageService {
    @Autowired
    public PageRepository pageRepository;

    public CustomException customException;

    public Page create(Page value){
        Integer score=value.getScore();
        if(score>100) {
            throw new CustomException("number should be less than 100", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return pageRepository.save(value);
    }

    public List<Page> get(Integer pagenumber,Integer pagesize,String order,String orderby){
            Pageable pageable= PageRequest.of(pagenumber,pagesize, Sort.by(Sort.Direction.fromString(order),orderby));
            org.springframework.data.domain.Page<Page> file=pageRepository.findAll(pageable);
            if(file.hasContent()){
            return file.getContent();
            }else {
            return new ArrayList<Page>();
        }
    }

    public List<Page> get1(String fromdate,String todate){
        DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate frdate= LocalDate.parse(fromdate,format);
        LocalDate tdate= LocalDate.parse(todate,format);
        List<Page> list=pageRepository.findByDob(frdate, tdate);
        return list;
    }

}
