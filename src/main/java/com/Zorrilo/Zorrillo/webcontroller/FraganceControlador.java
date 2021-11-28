package com.Zorrilo.Zorrillo.webcontroller;

import java.util.List;
import java.util.Optional;

import com.Zorrilo.Zorrillo.model.Fragance;
import com.Zorrilo.Zorrillo.service.FraganceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fragance")
public class FraganceControlador {

    @Autowired
    private FraganceService fraganceService;

    public FraganceControlador(FraganceService fraganceService) {
        this.fraganceService = fraganceService;
    }

    @CrossOrigin
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Fragance fragance){
        fraganceService.save(fragance);
    }


    @CrossOrigin
    @GetMapping("/all")
    public List<Fragance>getFragance(){
        return fraganceService.getAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<Fragance>getFragance(@PathVariable("id") String id){
        return fraganceService.getFragance(id);
    }

    @CrossOrigin
    @GetMapping("/reporteprice/{price}")
    public List<Fragance> getFragancePorPrice(@PathVariable("price") Long price){
        return fraganceService.getFragancePorPrice(price);
    }

    @CrossOrigin
    @GetMapping("/reportepricemdb/{price}")
    public List<Fragance> getFragancePorPriceMdb(@PathVariable("price") Long price){
        return fraganceService.getFragancePorPriceMdb(price);
    }
    @CrossOrigin
    @GetMapping("/reportepricemdb/{price}/{quantity}")
    public List<Fragance> getFragancePorPriceQuantityMdb(@PathVariable("price") Long price, @PathVariable("quantity") Integer quantity ){
        return fraganceService.getFragancePorPriceQuantityMdb(price, quantity);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteFragance(@PathVariable("id") String id){
        return fraganceService.deleteFragance(id);
    }

    @CrossOrigin
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Fragance update(@RequestBody Fragance fragance){
        return fraganceService.update(fragance);
    }


    
}
