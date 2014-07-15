package com.dannysoft.model.seguridad;


import com.dannysoft.model.core.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuario", schema = "seguridad")
public class Usuario extends BaseEntity {
    
    @Column()
    private String username;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "poster")
//    private Set<Tweet> tweets = new HashSet<Tweet>();

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

//    public void setTweets(Set<Tweet> tweets) {
//        this.tweets = tweets;
//    }
//
//    public Set<Tweet> getTweets() {
//        return tweets;
//    }
}
