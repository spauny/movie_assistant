/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package verii.movie_assistant.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import verii.movie_assistant.model.CastType;

/**
 *
 * @author Verii
 */
@Repository("castTypeDao")
@Transactional
public class CastTypeDaoImpl extends GenericDaoImpl<CastType,Integer> implements CastTypeDao  {

    public CastTypeDaoImpl() {
        super(CastType.class);
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<CastType> findAll() {
      return em.createNamedQuery("CastType.findAll").getResultList();
    }
}
