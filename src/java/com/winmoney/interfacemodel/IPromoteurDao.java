/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winmoney.modeldao;

import com.winmoney.entities.Chefservice;
import com.winmoney.entities.Dg;
import com.winmoney.entities.Secretaire;

import java.util.List;


public interface IPromoteurDao {
    
     Dg addDg(Dg dg, int idPromoteur);
     void DeleteDg(int id);
     Dg updateDg(Dg dg); 
     Dg findDg(int id);
     List<Dg> findAllDg();

     Secretaire addSecreatire(Secretaire secretaire, int idPromoteur);
     void DeleteSecretaire(int id);
    Secretaire updateSecretaire(Secretaire secretaire);
     Secretaire findSecretaire(int id);


    Chefservice addChefService(Chefservice chefservice, int idPromoteur);
     void DeleteChefService(int id);
     Chefservice updateChefService(Chefservice chefservice);
     Chefservice findChefService(int id);
     List<Chefservice> findAllChefService();


}
