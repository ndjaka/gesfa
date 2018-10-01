/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winmoney.modeldao;

import com.winmoney.entities.Client;

/**
 *
 * @author ndjaka
 */
public interface IClientDao {
    
      public Client getClientByTelephone(String Phone);
           
       
}
