package com.example.estetica;

public class Usuarios {
    private String usr;
    private Integer pass;
    private Integer tel;

    public Usuarios() {
    }

    public Usuarios(String usr, Integer pass, Integer tel) {
        this.usr = usr;
        this.pass = pass;
        this.tel = tel;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public Integer getPass() {
        return pass;
    }

    public void setPass(Integer pass) {
        this.pass = pass;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }
}
