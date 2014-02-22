/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package verii.movie_assistant.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author iuli
 */
@Entity
@Table(name = "movie_person")
@NamedQueries({
    @NamedQuery(name = "MoviePerson.findAll", query = "SELECT m FROM MoviePerson m"),
    @NamedQuery(name = "MoviePerson.findById", query = "SELECT m FROM MoviePerson m WHERE m.id = :id"),
    @NamedQuery(name = "MoviePerson.findByFirstName", query = "SELECT m FROM MoviePerson m WHERE m.firstName = :firstName"),
    @NamedQuery(name = "MoviePerson.findByLastName", query = "SELECT m FROM MoviePerson m WHERE m.lastName = :lastName"),
    @NamedQuery(name = "MoviePerson.findByMiddleName", query = "SELECT m FROM MoviePerson m WHERE m.middleName = :middleName"),
    @NamedQuery(name = "MoviePerson.findByBirthDate", query = "SELECT m FROM MoviePerson m WHERE m.birthDate = :birthDate"),
    @NamedQuery(name = "MoviePerson.findByTradeMark", query = "SELECT m FROM MoviePerson m WHERE m.tradeMark = :tradeMark")})
public class MoviePerson implements EntityItem {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "last_name")
    private String lastName;
    @Size(max = 250)
    @Column(name = "middle_name")
    private String middleName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Size(max = 250)
    @Column(name = "trade_mark")
    private String tradeMark;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moviePersonId")
    private List<MovieCast> movieCastList;

    public MoviePerson() {
    }

    public MoviePerson(Integer id) {
        this.id = id;
    }

    public MoviePerson(Integer id, String firstName, String lastName, Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(String tradeMark) {
        this.tradeMark = tradeMark;
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
        if (!(object instanceof MoviePerson)) {
            return false;
        }
        MoviePerson other = (MoviePerson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "verii.movie_assistant.model.MoviePerson[ id=" + id + " ]";
    }
    
}
