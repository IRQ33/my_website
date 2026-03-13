package com.irq3.domain.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.irq3.infrastructure.security.Bcrypt;
import com.irq3.infrastructure.security.EnvController;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;

import java.time.LocalDateTime;

@Serdeable
@MappedEntity("users")
public class User {

    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    private long id;
    private String name;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String password;
    private LocalDateTime dateCreated;
    private boolean mute = false;

    private User(){}

    public static User create(String name, String email, String password){
        if(name.isBlank() || email.isBlank() || password.isBlank()){
            throw new RuntimeException("Name or mail or password is empty");
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setDateCreated(LocalDateTime.now());
        return user;
    }

    public void hashPassword(){
        String password = Bcrypt.hashpw(this.getPassword(),EnvController.getEnvValue("password"));
        this.setPassword(password);
    }
    public boolean checkPassword(String password){
        return Bcrypt.checkpw(password,this.getPassword());
    }

    public boolean isMute() {
        return mute;
    }

    public void setMute(boolean mute) {
        this.mute = mute;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    private void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}
