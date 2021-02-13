package model;

import javafx.scene.image.Image;

import  java.util.ArrayList;
public class Classroom {
    private  ArrayList<UserAccount> accounts;

    public Classroom(){
        accounts = new ArrayList<UserAccount>();
    }

    public ArrayList<UserAccount>getAccounts(){
        return  accounts;

    }
    public void addAccount(UserAccount newAccount) {
        accounts.add(newAccount);

    }

    public boolean canLogin(String username , String password){
        boolean can = false;
        for (int i = 0; i <accounts.size() && can !=true; i++) {
            if ((accounts.get(i).getUsername()).equals(username) && (accounts.get(i).getPassword()).equals(password)) {
                can = true;

            }
        }
        return can;
    }

    public Image currentImage(String name){
        boolean out=false;
        Image image = null;
        for (int i = 0; i <accounts.size() && !out ; i++) {
            if((accounts.get(i).getUsername()).equals(name)){
               image = (accounts.get(i).getProfile());
                out=true;
                //System.out.println("Entrocsm");

            }

        }

        return image;

    }





}
