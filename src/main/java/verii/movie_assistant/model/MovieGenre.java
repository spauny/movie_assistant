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
@Table(name = "movie_genre")
@NamedQueries({
    @NamedQuery(name = "MovieGenre.findAll", query = "SELECT m FROM MovieGenre m"),
    @NamedQuery(name = "MovieGenre.findById", query = "SELECT m FROM MovieGenre m WHERE m.id = :id")})
public class MovieGenre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Genre genreId;
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Movie movieId;

    public MovieGenre() {
    }

    public MovieGenre(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Genre getGenreId() {
        return genreId;
    }

    public void setGenreId(Genre genreId) {
        this.genreId = genreId;
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
        if (!(object instanceof MovieGenre)) {
            return false;
        }
        MovieGenre other = (MovieGenre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "verii.movie_assistant.model.MovieGenre[ id=" + id + " ]";
    }
    
}
