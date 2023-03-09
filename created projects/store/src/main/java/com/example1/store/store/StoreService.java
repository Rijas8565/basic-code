package com.example1.store.store;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Component
@Service
public class StoreService {

    public StoreRepository storeRepository;


    public List<Store> get(Integer id){
        if(id==null){
          List<Store> list1=storeRepository.findByIdSorted();
          return list1;
        }
        else{
            List<Store> list1 = storeRepository.findByIdGreaterThan(id).stream().toList();
            return list1;
        }
    }
    public List<Store> get1(){
        List<Store> list1 = storeRepository.findByIdPredefined().stream().toList();
        return list1;
    }

    public Store create(Store value){
        return storeRepository.save(value);
    }

    public Store update(Integer id,Store value){
        Store store=storeRepository.findById(id).orElse(value);
        store.setName(value.getName());
        store.setNumber(value.getNumber());
        return storeRepository.save(store);
    }

    public String delete(Integer id){
        storeRepository.findById(id).orElseThrow(()->new RuntimeException("id not found"));
        storeRepository.deleteById(id);
        return "id "+id+" is deleted";
    }
}
