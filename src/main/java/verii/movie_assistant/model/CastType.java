/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package verii.movie_assistant.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author iuli
 */
@Entity
@Table(name = "cast_type")
@NamedQueries({
    @NamedQuery(name = "CastType.findAll", query = "SELECT c FROM CastType c"),
    @NamedQuery(name = "CastType.findById", query = "SELECT c FROM CastType c WHERE c.id = :id"),
    @NamedQuery(name = "CastType.findByType", query = "SELECT c FROM CastType c WHERE c.type = :type")})
public class CastType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "type")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "castTypeId")
    private List<MovieCast> movieCastList;

    public CastType() {
    }

    public CastType(Integer id) {
        this.id = id;
    }

    public CastType(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<MovieCast> getMovieCastList() {
        return movieCastList;
    }

    public void setMovieCastList(List<MovieCast> movieCastList) {
        this.movieCastList = movieCastList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CastType)) {
            return false;
        }
        CastType other = (CastType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "verii.movie_assistant.model.CastType[ id=" + id + " ]";
    }
    
}
