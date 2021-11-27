package com.example.pafitness;

public class RecyclerModel {

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
}
