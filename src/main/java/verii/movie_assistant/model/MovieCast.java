/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package verii.movie_assistant.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author iuli
 */
@Entity
@Table(name = "movie_cast")
@NamedQueries({
    @NamedQuery(name = "MovieCast.findAll", query = "SELECT m FROM MovieCast m"),
    @NamedQuery(name = "MovieCast.findById", query = "SELECT m FROM MovieCast m WHERE m.id = :id")})
public class MovieCast implements EntityItem {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "movie_person_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MoviePerson moviePersonId;
    @JoinColumn(name = "cast_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CastType castTypeId;
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Movie movieId;

    public MovieCast() {
    }

    public MovieCast(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MoviePerson getMoviePersonId() {
        return moviePersonId;
    }

    public void setMoviePersonId(MoviePerson moviePersonId) {
        this.moviePersonId = moviePersonId;
    }

    public CastType getCastTypeId() {
        return castTypeId;
    }

    public void setCastTypeId(CastType castTypeId) {
        this.castTypeId = castTypeId;
    }

    public Movie getMovieId() {
        return movieId;
    }

    public void setMovieId(Movie movieId) {
        this.movieId = movieId;
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
        if (!(object instanceof MovieCast)) {
            return false;
        }
        MovieCast other = (MovieCast) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "verii.movie_assistant.model.MovieCast[ id=" + id + " ]";
    }
    
}
