package com.dannysoft.model.inventario;


import com.dannysoft.model.core.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "producto", schema = "inventario")
public class Producto extends BaseEntity {
       
    public Producto() {
    }
        
}
