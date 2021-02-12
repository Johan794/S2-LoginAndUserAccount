package model;
import  java.util.ArrayList;
public class Classroom {
    private  ArrayList<UserAccount> accounts;

    public Classroom(){
        accounts = new ArrayList<UserAccount>();
    }

    public ArrayList<UserAccount>getAccounts(){
        return  accounts;
    }
    public void  addAccount(UserAccount newAccount){
        accounts.add(newAccount);
    }




}
