package com.example.pafitness;

import android.os.Parcel;
import android.os.Parcelable;

public class RecyclerModel implements Parcelable {

    String name, address;
    int fitness;

    public RecyclerModel(String name, String address, int fitness) {
        this.name = name;
        this.address = address;
        this.fitness = fitness;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getFitness() {
        return fitness;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.address);
        dest.writeInt(this.fitness);
    }

    public void readFromParcel(Parcel source) {
        this.name = source.readString();
        this.address = source.readString();
        this.fitness = source.readInt();
    }

    protected RecyclerModel(Parcel in) {
        this.name = in.readString();
        this.address = in.readString();
        this.fitness = in.readInt();
    }

    public static final Creator<RecyclerModel> CREATOR = new Creator<RecyclerModel>() {
        @Override
        public RecyclerModel createFromParcel(Parcel source) {
            return new RecyclerModel(source);
        }

        @Override
        public RecyclerModel[] newArray(int size) {
            return new RecyclerModel[size];
        }
    };
}
