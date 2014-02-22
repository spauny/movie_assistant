/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package verii.movie_assistant.dao;


import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import verii.movie_assistant.model.MovieGenre;
/**
 *
 * @author Verii
 */
public class MovieGenreDaoImpl extends GenericDaoImpl<MovieGenre,Integer> implements MovieGenreDao {
    
      public MovieGenreDaoImpl() {
        super(MovieGenre.class);
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<MovieGenre> findAll() {
      return em.createNamedQuery("MovieGenre.findAll").getResultList();
    }
}
