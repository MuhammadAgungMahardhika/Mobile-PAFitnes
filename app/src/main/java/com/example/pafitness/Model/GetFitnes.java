package com.example.pafitness.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class GetFitnes implements Parcelable {

    @SerializedName("harga_perbulan")
    private int hargaPerbulan;

    @SerializedName("jam_buka")
    private String jamBuka;

    @SerializedName("alamat_fitnes")
    private String alamatFitnes;

    @SerializedName("nama_fitnes")
    private String namaFitnes;

    @SerializedName("id")
    private int id;

    @SerializedName("fasilitas")
    private String fasilitas;

    @SerializedName("no_fitnes")
    private int noFitnes;

    @SerializedName("gambar_fitnes")
    private String gambarFitnes;

    public int getHargaPerbulan(){
        return hargaPerbulan;
    }

    public String getJamBuka(){
        return jamBuka;
    }

    public String getAlamatFitnes(){
        return alamatFitnes;
    }

    public String getNamaFitnes(){
        return namaFitnes;
    }

    public int getId(){
        return id;
    }

    public String getFasilitas(){
        return fasilitas;
    }

    public int getNoFitnes(){
        return noFitnes;
    }

    public String getGambarFitnes(){
        return gambarFitnes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(hargaPerbulan);
        parcel.writeString(jamBuka);
        parcel.writeString(alamatFitnes);
        parcel.writeString(namaFitnes);
        parcel.writeInt(id);
        parcel.writeString(fasilitas);
        parcel.writeInt(noFitnes);
        parcel.writeString(gambarFitnes);
    }

    public void readFromParcel(Parcel source) {
        this.hargaPerbulan = source.readInt();
        this.jamBuka = source.readString();
        this.alamatFitnes = source.readString();
        this.namaFitnes = source.readString();
        this.id = source.readInt();
        this.fasilitas = source.readString();
        this.noFitnes = source.readInt();
        this.gambarFitnes = source.readString();
    }

    protected GetFitnes(Parcel in) {
        this.hargaPerbulan = in.readInt();
        this.jamBuka = in.readString();
        this.alamatFitnes = in.readString();
        this.namaFitnes = in.readString();
        this.id = in.readInt();
        this.fasilitas = in.readString();
        this.noFitnes = in.readInt();
        this.gambarFitnes = in.readString();
    }

    public static final Creator<GetFitnes> CREATOR = new Creator<GetFitnes>() {
        @Override
        public GetFitnes createFromParcel(Parcel source) {
            return new GetFitnes(source);
        }

        @Override
        public GetFitnes[] newArray(int size) {
            return new GetFitnes[size];
        }
    };
}