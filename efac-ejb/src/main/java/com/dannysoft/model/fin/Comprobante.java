package com.dannysoft.model.fin;


import com.dannysoft.model.core.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "compobante", schema = "fin")
public class Comprobante extends BaseEntity {
       
    public Comprobante() {
        
    }
        
}
