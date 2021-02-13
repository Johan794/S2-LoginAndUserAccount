package model;

import javafx.scene.image.Image;



public class UserAccount {
    private String username;
    private String password;
    private String gender;
    private  String career;
    private  String birthday;
    private  String browser;
    private Image profile;

    public UserAccount(String username, String password, String gender, String career, String birthday, String browser, Image profile) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.career = career;
        this.birthday = birthday;
        this.browser = browser;
        this.profile = profile;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getCareer() {
        return career;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getBrowser() {
        return browser;
    }

    public Image getProfile(){
       // System.out.println("Entrocsm");
        return profile;
    }

    public void setProfile(Image nProfile){
        //System.out.println("Set done");
        profile=nProfile;
    }
}
