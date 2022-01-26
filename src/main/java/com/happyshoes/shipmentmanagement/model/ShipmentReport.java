package com.happyshoes.shipmentmanagement.model;

import java.io.Serializable;
import java.util.Set;

public class ShipmentReport implements Serializable {

    private String deliveryStatus;

    private Double shipmentsCost;

    private Set<String> packingTypes;

    public ShipmentReport(String deliveryStatus, Double shipmentsCost, Set<String> packingTypes) {
        this.deliveryStatus = deliveryStatus;
        this.shipmentsCost = shipmentsCost;
        this.packingTypes = packingTypes;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Double getShipmentsCost() {
        return shipmentsCost;
    }

    public void setShipmentsCost(Double shipmentsCost) {
        this.shipmentsCost = shipmentsCost;
    }

    public Set<String> getPackingTypes() {
        return packingTypes;
    }

    public void setPackingTypes(Set<String> packingTypes) {
        this.packingTypes = packingTypes;
    }

    @Override
    public String toString() {
        return "ShipmentReport{" +
                "deliveryStatus='" + deliveryStatus + '\'' +
                ", shipmentsCost=" + shipmentsCost +
                ", packingTypes=" + packingTypes +
                '}';
    }

}
