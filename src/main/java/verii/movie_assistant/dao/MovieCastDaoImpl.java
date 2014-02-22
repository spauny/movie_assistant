/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package verii.movie_assistant.dao;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import verii.movie_assistant.model.MovieCast;

/**
 *
 * @author Verii
 */
public class MovieCastDaoImpl extends GenericDaoImpl<MovieCast,Integer> implements MovieCastDao {
    
     public MovieCastDaoImpl() {
        super(MovieCast.class);
    }
    
    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<MovieCast> findAll()
    {
        return em.createNamedQuery("MovieCast.findAll").getResultList();
    }
}
