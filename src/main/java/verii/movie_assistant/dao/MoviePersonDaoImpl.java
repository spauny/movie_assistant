/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package verii.movie_assistant.dao;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import verii.movie_assistant.model.MoviePerson;

/**
 *
 * @author Verii
 */
public class MoviePersonDaoImpl extends GenericDaoImpl<MoviePerson,Integer> implements MoviePersonDao {
    
     public MoviePersonDaoImpl() {
        super(MoviePerson.class);
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<MoviePerson> findAll() {
      return em.createNamedQuery("MoviePerson.findAll").getResultList();
    }
    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<MoviePerson> findByFirstName(String firstName) {
      return em.createNamedQuery("MoviePerson.findByFirstName").setParameter("FirstName",firstName).getResultList();
    }
}
