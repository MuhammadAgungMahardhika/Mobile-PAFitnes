package com.example.pafitness.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetBookingClass {

    @SerializedName("id_booking")
    @Expose
    private Integer idBooking;
    @SerializedName("id_fitnes")
    @Expose
    private Integer idFitnes;
    @SerializedName("id_user")
    @Expose
    private String idUser;
    @SerializedName("tanggal_booking")
    @Expose
    private String tanggalBooking;
    @SerializedName("nama_fitnes")
    @Expose
    private String namaFitnes;
    @SerializedName("alamat_fitnes")
    @Expose
    private String alamatFitnes;
    @SerializedName("harga_perbulan")
    @Expose
    private Integer hargaPerbulan;

    public Integer getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Integer idBooking) {
        this.idBooking = idBooking;
    }

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

    public String getTanggalBooking() {
        return tanggalBooking;
    }

    public void setTanggalBooking(String tanggalBooking) {
        this.tanggalBooking = tanggalBooking;
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

    public Integer getHargaPerbulan() {
        return hargaPerbulan;
    }

    public void setHargaPerbulan(Integer hargaPerbulan) {
        this.hargaPerbulan = hargaPerbulan;
    }

    }


