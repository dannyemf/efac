package com.dannysoft.rep;

import static com.dannysoft.model.seguridad.QUsuario.usuario;
import com.dannysoft.model.seguridad.Usuario;

import java.util.List;

import com.mysema.query.types.Predicate;
import javax.persistence.EntityManager;

//@Transactional
public class UserRepository extends AbstractRepository<Usuario> {

    public UserRepository(EntityManager em) {
        super(em);        
    }        
    
    @Override
    public Usuario findById(Long id) {
        return find(Usuario.class, id);
    }

    public Usuario save(Usuario user) {
        return persistOrMerge(user);
    }

    public List<Usuario> findAll(Predicate expr) {
        return from(usuario).where(expr).list(usuario);
    }
    
    public long countAll(Predicate expr) {
        return from(usuario).where(expr).count();
    }
    
    public List<Usuario> all() {
        return from(usuario).list(usuario);
    }
    
    public long count() {
        return from(usuario).count();
    }
}
