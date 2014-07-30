package com.dannysoft.model.seguridad;


import com.dannysoft.model.core.BaseEntity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario", schema = "seguridad")
public class Usuario extends BaseEntity {
    
    @Column(unique = true, length = 25)
    private String username;
    
    @Column(nullable = false, length = 100)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="usuario_grupo", schema = "seguridad",
      joinColumns={@JoinColumn(name="usuario_id", referencedColumnName="id")},
      inverseJoinColumns={@JoinColumn(name="grupo_id", referencedColumnName="id")})
    private Set<Grupo> grupos = new HashSet<Grupo>();

    public Usuario() {
        
    }

    public Usuario(Long id, String username) {
        setId(id);
        this.username = username;
    }

    public Usuario(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the grupos
     */
    public Set<Grupo> getGrupos() {
        return grupos;
    }

    /**
     * @param grupos the grupos to set
     */
    public void setGrupos(Set<Grupo> grupos) {
        this.grupos = grupos;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
