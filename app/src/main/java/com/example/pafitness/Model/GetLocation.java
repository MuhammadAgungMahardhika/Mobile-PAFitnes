package com.example.pafitness.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetLocation {
    @SerializedName("id_location")
    @Expose
    private Integer idLocation;
    @SerializedName("id_fitnes")
    @Expose
    private Integer idFitnes;
    @SerializedName("nama_fitnes")
    @Expose
    private String namaFitnes;
    @SerializedName("alamat_fitnes")
    @Expose
    private String alamatFitnes;
    @SerializedName("jam_buka")
    @Expose
    private String jamBuka;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lng")
    @Expose
    private String lng;

    public Integer getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public Integer getIdFitnes() {
        return idFitnes;
    }

    public void setIdFitnes(Integer idFitnes) {
        this.idFitnes = idFitnes;
    }

    public String getNamaFitnes() {
        return namaFitnes;
    }

    public void setNamaFitnes(String namaFitnes) {
        this.namaFitnes = namaFitnes;
    }

    public String getAlamatFitnes() {
        return alamatFitnes;
    }

    public void setAlamatFitnes(String alamatFitnes) {
        this.alamatFitnes = alamatFitnes;
    }

    public String getJamBuka() {
        return jamBuka;
    }

    public void setJamBuka(String jamBuka) {
        this.jamBuka = jamBuka;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
