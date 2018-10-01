/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ndjaka
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println(testCaractere("NGo SEH BAH"));
        
    }
    
    public static String testCaractere(String nom){
         
         String mot = "";
        for(int i=0 ;i<3;i++){
            
             mot = mot + nom.charAt(i);
             
        }
          if(mot.equalsIgnoreCase("ngo") ){
              return "oui";
          }else{
              return "non";
          }
    }
}
