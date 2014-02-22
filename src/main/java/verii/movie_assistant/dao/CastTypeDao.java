/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package verii.movie_assistant.dao;

import java.util.List;
import verii.movie_assistant.model.CastType;

/**
 *
 * @author Nenos
 */
public interface CastTypeDao extends GenericDao<CastType,Integer> {
    
    List<CastType> findAll();
}
