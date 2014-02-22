/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package verii.movie_assistant.dao;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import verii.movie_assistant.model.Movie;

/**
 *
 * @author Verii
 */
public class MovieDaoImpl extends GenericDaoImpl<Movie,Integer> implements MovieDao {
    
     public MovieDaoImpl() {
        super(Movie.class);
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Movie> findAll() {
      return em.createNamedQuery("Movie.findAll").getResultList();
    }
    
    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Movie> findByTitle(String inTitle) {
      return em.createNamedQuery("Movie.findByTitle").setParameter("FirstName",inTitle).getResultList();
    }
    
}
