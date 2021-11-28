package com.Zorrilo.Zorrillo.service;

import java.util.List;
import java.util.Optional;

import com.Zorrilo.Zorrillo.model.Fragance;
import com.Zorrilo.Zorrillo.repository.FraganceRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraganceService {
    @Autowired
    private FraganceRepositorio fragancerepositorio;

    public Fragance save(Fragance fragance){
        if (fragance.getId()==null) {
            return fragancerepositorio.save(fragance);
            
        } else {
            Optional<Fragance> consulta=fragancerepositorio.getFragance(fragance.getId());
            if (consulta.isEmpty()) {
                return fragancerepositorio.save(fragance);
                
            } else {
                return fragance;                
            }
            
        }
    }

    public List<Fragance>getAll(){
        return fragancerepositorio.getAll();
    }

    public Optional<Fragance>getFragance(String id){
        return fragancerepositorio.getFragance(id);
    }

    public List<Fragance> getFragancePorPrice(Long price){
        return fragancerepositorio.getFragancePorPrice(price);
    }

    public List<Fragance>getFragancePorPriceMdb(Long price){
        return fragancerepositorio.getFragancePorPriceMdb(price);
    }

    public List<Fragance>getFragancePorPriceQuantityMdb(Long price, Integer quantity){
        return fragancerepositorio.getFragancePorPriceQuantityMdb(price, quantity);
    } 

    public boolean deleteFragance(String id){
        Optional<Fragance> consulta=fragancerepositorio.getFragance(id);
        if (!consulta.isEmpty()) {
            fragancerepositorio.delete(consulta.get());
            return true;
            
        }
        return false;
    }

    public Fragance update(Fragance fragance){
        if (fragance.getId()!=null) {
            Optional<Fragance> consulta=fragancerepositorio.getFragance(fragance.getId());
            if (!consulta.isEmpty()) {
                if (fragance.getCategory()!=null) {
                    consulta.get().setCategory(fragance.getCategory());                    
                }
                if(fragance.getReference()!=null){
                    consulta.get().setReference(fragance.getReference());
                }
                if(fragance.getBrand()!=null){
                    consulta.get().setBrand(fragance.getBrand());
                }
                if (fragance.getPrice()!=null) {
                    consulta.get().setPrice(fragance.getPrice());
                    
                }
                if (fragance.getDescription()!=null) {
                    consulta.get().setDescription(fragance.getDescription());                   
                }
                if (fragance.getAvailability()!=null) {
                    consulta.get().setAvailability(fragance.getAvailability());                    
                }
                if (fragance.getQuantity()!=null) {
                    consulta.get().setQuantity(fragance.getQuantity());                    
                }
                if (fragance.getPhotography()!=null) {
                    consulta.get().setPhotography(fragance.getPhotography());                    
                }
                return fragancerepositorio.save(consulta.get());
            }            
        }
        return fragance;

    }


    




    
}
