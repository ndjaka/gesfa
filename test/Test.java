
import com.winmoney.dao.DAO;
import com.winmoney.entities.Chefservice;
import com.winmoney.entities.Client;
import com.winmoney.entities.Commande;

import com.winmoney.entities.Produit;
import com.winmoney.entities.Promoteur;
import com.winmoney.entities.Secretaire;


import com.winmoney.modeldao.SecretaireDao;
import java.util.Arrays;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ndjaka
 */
public class Test {
    public static void main(String[] args) {
//////        PromoteurDao pd = new PromoteurDao();
//////         Chefservice chefservice = new Chefservice();
//////         chefservice.setAdressemail("asdfff");
//////         chefservice.setIduser(1);
//////        System.out.println("****"+Arrays.toString(pd.findAllChefService().toArray()));
        
        SecretaireDao secretaireDao = new SecretaireDao();
        Client client = new Client();
        client.setNomclient("nom");
        client.setAdressemail("eugenendjaka@gmail.com");
        
        
        Commande commande = new Commande();
        commande.setSecretaire(new Secretaire(1));
        commande.setDatecommande(new Date());
        
        
     
        String res = secretaireDao.enregistrerCommande(1, commande, client, "voute", 50);
        System.out.println("**********"+res);
       
}
}