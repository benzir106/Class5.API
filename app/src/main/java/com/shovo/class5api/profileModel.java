package com.shovo.class5api;

public class profileModel {

    private String email;
   private String first_name;
   private String last_name;
    private String avart;

    public profileModel(String email, String first_name, String last_name, String avart) {
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avart = avart;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAvart() {
        return avart;
    }
}
