/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package verii.movie_assistant.dao;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import verii.movie_assistant.model.Genre;

/**
 *
 * @author Verii
 */
public class GenreDaoImpl extends GenericDaoImpl<Genre,Integer> implements GenreDao {
    
     public GenreDaoImpl() {
        super(Genre.class);
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Genre> findAll() {
      return em.createNamedQuery("Genre.findAll").getResultList();
    }
}
