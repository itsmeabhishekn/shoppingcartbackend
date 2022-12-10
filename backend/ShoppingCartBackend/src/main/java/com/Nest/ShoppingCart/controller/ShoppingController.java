package com.Nest.ShoppingCart.controller;

import com.Nest.ShoppingCart.dao.ProductDao;
import com.Nest.ShoppingCart.dao.RegisterDao;
import com.Nest.ShoppingCart.model.Products;
import com.Nest.ShoppingCart.model.Registration;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class ShoppingController {

    @Autowired
    private RegisterDao daoReg;

    @Autowired
    private ProductDao daoProd;


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userSearch",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> userSearch(@RequestBody Registration u){
        System.out.println(u.getEmailId());
        System.out.println(u.getPassword());
        List<Registration> checkData = (List<Registration>) daoReg.findUserLogin(u.getEmailId(),u.getPassword());
        System.out.println(checkData);
        HashMap<String,String> hashmap= new HashMap<>();
        if(checkData.size()==0){
            hashmap.put("status","failed");
            hashmap.put("message","user does not exist");
        }
        else{
            int id=checkData.get(0).getId();
            hashmap.put("userid",String.valueOf(id));
            hashmap.put("status","success");
            hashmap.put("message","user exists");
        }
        return hashmap;
    }




    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userbyid",consumes = "application/json",produces = "application/json")
    public List<Registration> userGetById(@RequestBody Registration u){
        return (List<Registration>) daoReg.findUserById(u.getId());
    }



    @CrossOrigin(origins = "*")
    @PostMapping(path = "/register",consumes = "application/json", produces = "application/json")
    public HashMap<String,String> registerUser(@RequestBody Registration r){

        daoReg.save(r);
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");

        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",consumes = "application/json", produces = "application/json")
    public HashMap<String, String> addProduct(@RequestBody Products p){

        daoProd.save(p);
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");

        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json", produces = "application/json")
    public List<Products> searchProduct(@RequestBody Products p){

        return (List<Products>) daoProd.searchProd(p.getName());
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewall")
    public List<Products> viewProducts(){

        return (List<Products>) daoProd.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/getUID" ,consumes = "application/json", produces = "application/json")
    public List<Registration> searchUid(@RequestBody Registration uid){
        return  (List<Registration>)  daoReg.findUserById(uid.getId());
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchProduct",consumes = "application/json", produces = "application/json")
    public List<Products> searchProd(@RequestBody Products p){

        return (List<Products>) daoProd.searchProd(p.getName());
    }


    //To display search results
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/view",consumes = "application/json", produces = "application/json")
    public List<Products> viewProduct(){

        return (List<Products>) daoProd.findAll();
    }



}
