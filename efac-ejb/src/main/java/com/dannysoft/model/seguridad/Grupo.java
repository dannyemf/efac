package com.dannysoft.model.seguridad;


import com.dannysoft.model.core.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "grupo", schema = "seguridad")
public class Grupo extends BaseEntity {
    
    @Column(unique = true)
    private String groupname;

    public Grupo() {
        
    }

    public Grupo(Long id, String username) {
        setId(id);
        this.groupname = username;
    }

    public Grupo(String username) {
        this.groupname = username;
    }

    /**
     * @return the groupname
     */
    public String getGroupname() {
        return groupname;
    }

    /**
     * @param groupname the groupname to set
     */
    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    
}
