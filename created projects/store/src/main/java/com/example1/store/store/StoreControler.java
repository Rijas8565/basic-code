package com.example1.store.store;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/store2")
public class StoreControler {

   // static final Logger logger= LoggerFactory.getLogger(StoreControler.class);
    @Autowired
    public StoreService storeService;
    @Autowired
    public StoreRepository storeRepository;

    public StoreControler(StoreService storeService){
        this.storeService=storeService;
    }
    public StoreControler(){

    }

/*
    @Value("${spring.datasource.username}")
    private String username;

    @RequestMapping(method = RequestMethod.GET,value = "/value")
    public String getUsername(){
        logger.info(username);
        return username;
    }
*/


    //get
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> get(@RequestParam(required = false) Integer id){
        return ResponseEntity.ok(storeService.get(id));
    }
    //get predefined
    @RequestMapping(method = RequestMethod.GET,value = "/value")
    public ResponseEntity<?> get1(){
        return ResponseEntity.ok(storeService.get1());
    }

    //create
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Store> create(@RequestBody Store value){
        return ResponseEntity.ok(storeService.create(value));
    }
    //update
    @RequestMapping(method = RequestMethod.PUT,value = "/{id}")
    public ResponseEntity<Store> update(@PathVariable Integer id,@RequestBody Store value){
        return ResponseEntity.ok(storeService.update(id, value));
    }
    //delete
    @RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
    public ResponseEntity<String> delete(Integer id){
        return ResponseEntity.ok(storeService.delete(id));
    }

}
