package com.example.pafitness.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostBooking {

        @SerializedName("id_fitnes")
        @Expose
        private Integer idFitnes;
        @SerializedName("id_user")
        @Expose
        private String idUser;

        public Integer getIdFitnes() {
            return idFitnes;
        }

        public void setIdFitnes(Integer idFitnes) {
            this.idFitnes = idFitnes;
        }

        public String getIdUser() {
            return idUser;
        }

        public void setIdUser(String idUser) {
            this.idUser = idUser;
        }


}
