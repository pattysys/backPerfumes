package com.Zorrilo.Zorrillo.repository;

import java.util.List;
import java.util.Optional;

import com.Zorrilo.Zorrillo.model.Fragance;
import com.Zorrilo.Zorrillo.repository.crud.FraganceCrudRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class FraganceRepositorio {

    @Autowired
    FraganceCrudRepositorio fraganceCrudRepositorio;

    public Fragance save(Fragance fragance){
        return fraganceCrudRepositorio.save(fragance);
    }

    public List<Fragance>getAll(){

        return (List<Fragance>)fraganceCrudRepositorio.findAll();
    }

    public Optional<Fragance>getFragance(String id){
        return fraganceCrudRepositorio.findById(id);
    }

    public List<Fragance> getFragancePorPrice(Long price){
        return fraganceCrudRepositorio.findAllByPriceLessThanEqual(price);
    }

    public List<Fragance> getFragancePorPriceMdb(Long price){
        return fraganceCrudRepositorio.getFraganceByPrice(price);
    }

    public List<Fragance> getFragancePorPriceQuantityMdb(Long price, Integer quantity){
        return fraganceCrudRepositorio.getFraganceByPriceQuantity(price, quantity);
    }

    public void delete(Fragance fragance){
        fraganceCrudRepositorio.delete(fragance);
    }





}

