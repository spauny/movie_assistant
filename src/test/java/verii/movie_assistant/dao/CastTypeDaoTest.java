/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package verii.movie_assistant.dao;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import verii.movie_assistant.model.CastType;

/**
 *
 * @author iuli
 */
public class CastTypeDaoTest extends AbstractDaoForTesting {
    
    public CastTypeDaoTest(){}
    
    @Test
    public void testFindAll() {
        List<CastType> expectedCastTypeList = new ArrayList<>();
        CastType castType = new CastType();
        castType.setId(1);
        castType.setType("ACTOR");
        expectedCastTypeList.add(castType);
        
        castType = new CastType();
        castType.setId(2);
        castType.setType("DIRECTOR");
        expectedCastTypeList.add(castType);
        
        List<CastType> actualCastTypeList = castTypeDao.findAll();
        
        Assert.assertEquals(actualCastTypeList, expectedCastTypeList);
    }
    
}
