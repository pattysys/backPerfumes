package com.Zorrilo.Zorrillo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Perfumes") 
public class Fragance {
    @Id
    private String id;
    private String reference;
    private String brand;
    private String category;
    private String presentation;
    private String description;
    private Boolean availability;
    private Long price;
    private Integer quantity; 
    private String photography;  
    
}
