package com.Zorrilo.Zorrillo.repository.crud;

import java.util.List;

import com.Zorrilo.Zorrillo.model.Fragance;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface FraganceCrudRepositorio extends MongoRepository<Fragance,String> {


    public List<Fragance> findAllByPriceLessThanEqual(Long price);

    
    @Query("{price:{$lte:?0}}")
    public List<Fragance> getFraganceByPrice(Long price);

    //{price:{$lte:330}, quantity:{$gte:300}}

    @Query("{price:{$lte:?0}, quantity:{$gte:?1}}")
    public List<Fragance> getFraganceByPriceQuantity(Long price, Integer quantity);




    
}
