/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winmoney.modeldao;

import com.winmoney.dao.DAO;
import com.winmoney.entities.Dg;

/**
 *
 * @author ndjaka
 */
public class DgDao extends DAO<Dg,Integer> implements com.winmoney.modeldao.IDgDao {
    
    
    public void deleteDg(int id){
        Dg dg ;
        dg = findById(id);
        dg.setEtat(Boolean.FALSE);
        update(dg);
    }
    
    
}
