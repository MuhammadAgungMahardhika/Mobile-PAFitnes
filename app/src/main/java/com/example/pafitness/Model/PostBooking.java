package com.example.pafitness.Model;

public class PostBooking {
    private Integer id_fitnes;
    private Integer id_user;

    public PostBooking(Integer id_fitnes, Integer id_user) {
        this.id_fitnes = id_fitnes;
        this.id_user = id_user;
    }

    public Integer getId_fitnes() {
        return id_fitnes;
    }

    public void setId_fitnes(Integer id_fitnes) {
        this.id_fitnes = id_fitnes;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }
}
