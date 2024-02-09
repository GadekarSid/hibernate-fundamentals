package org.example.entities;

import jakarta.persistence.Entity;

@Entity
public class ElectronicDevice extends Item{

    private String voltage;

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }
}
