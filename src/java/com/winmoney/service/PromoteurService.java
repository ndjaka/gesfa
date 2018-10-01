/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winmoney.service;

import com.winmoney.entities.Chefservice;
import com.winmoney.entities.Client;
import com.winmoney.entities.Dg;
import com.winmoney.entities.Promoteur;
import com.winmoney.entities.Secretaire;
import com.winmoney.modeldao.IPromoteurDao;
import com.winmoney.modeldao.PromoteurDao;
import com.winmoney.modeldao.SecretaireDao;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.resource.spi.AuthenticationMechanism;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/promoteur")
public class PromoteurService implements IPromoteurDao{
    PromoteurDao promoteurDao = new PromoteurDao();
    
   
    @Override
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/adddg/{idPromoteur}")
    public Dg addDg(Dg dg, @PathParam("idPromoteur") int idPromoteur) {
        return promoteurDao.addDg(dg, idPromoteur);
    }

    @Override
    @PUT
    @Path("/deletedg/{id}")
    public void DeleteDg(@PathParam("id") int id) {
       promoteurDao.DeleteDg(id);
    }

    @Override
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updatedg")
    public Dg updateDg(Dg dg) {
        return promoteurDao.updateDg(dg);
    }

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getdg/{id}")
    public Dg findDg(@PathParam("id")int id) {
        return promoteurDao.findDg(id);
    }

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getalldg")
    public List<Dg> findAllDg() {
      return promoteurDao.findAllDg();
    }

    
    /********************** SECRETAIRE*****************************/
    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    
    @Path("/addsecretaire/{idPromoteur}")
    public Secretaire addSecreatire(Secretaire secretaire,@PathParam("id") int idPromoteur) {
        return promoteurDao.addSecreatire(secretaire, idPromoteur);
    }

    @Override
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/deletesecretaire/{id}")
    public void DeleteSecretaire(@PathParam("id") int id) {
      promoteurDao.DeleteChefService(id);
    }

    @Override
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updatesecretaire")
    public Secretaire updateSecretaire(Secretaire secretaire) {
        return promoteurDao.updateSecretaire(secretaire);
    }

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getsecretaire/{id}")
    public Secretaire findSecretaire(@PathParam("id")int id) {
      return promoteurDao.findSecretaire(id);
    }
    
    
    
/*****************************chef service********************/
    @Override
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addchefservice/{idPromoteur}")
    public Chefservice addChefService(Chefservice chefservice,@PathParam("idPromoteur") int idPromoteur) {
        return promoteurDao.addChefService(chefservice, idPromoteur);
    }

    @Override
    @PUT
    @Path("/deletechefservice/{id}")
    public void DeleteChefService(@PathParam("id") int id) {
      promoteurDao.DeleteChefService(id);
    }

    @Override
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updatechefservice")
    public Chefservice updateChefService(Chefservice chefservice) {
       return promoteurDao.updateChefService(chefservice);
    }

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getchefservice/{id}")
    public Chefservice findChefService(@PathParam("id") int id) {
        return promoteurDao.findChefService(id);
    }

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getallchefservice")
    public List<Chefservice> findAllChefService() {
       return promoteurDao.findAllChefService();
    }
    
   
    
}
