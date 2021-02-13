package model;

import javafx.scene.image.Image;

import java.awt.*;

public class UserAccount {
    private String username;
    private String password;
    private String gender;
    private  String career;
    private  String birthday;
    private  String browser;
    private Image profile;

    public UserAccount(String username, String password, String gender, String career, String birthday, String browser) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.career = career;
        this.birthday = birthday;
        this.browser = browser;
        profile = null;
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
        return profile;
    }

    public void setProfile(Image profile){
        this.profile=profile;
    }
}
