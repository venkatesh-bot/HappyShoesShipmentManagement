package com.happyshoes.shipmentmanagement.service;

import com.happyshoes.shipmentmanagement.data.Shipments;
import com.happyshoes.shipmentmanagement.model.ShipmentReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShipmentReportService {

    private SmbShipperServiceClient smbShipperServiceClient;

    public List<ShipmentReport> getShipmentReport() {
        List<Shipments> shipments = smbShipperServiceClient.getAllShipments();
        if (!CollectionUtils.isEmpty(shipments)) {
            return new ArrayList<>(shipments.stream().collect(
                            Collectors.groupingBy(Shipments::getDeliveryStatus, Collectors.collectingAndThen(Collectors.toList(), groupedShipments -> {
                                DoubleSummaryStatistics shipmentsCost = groupedShipments.stream().collect(Collectors.summarizingDouble(s -> s.getCost().doubleValue()));
                                Set<String> packingTypes = groupedShipments.stream().map(Shipments::getPackageType).collect(Collectors.toSet());
                                String deliveryStatus = groupedShipments.stream().map(Shipments::getDeliveryStatus).findFirst().orElseGet(null);
                                return new ShipmentReport(deliveryStatus, shipmentsCost.getSum(), packingTypes);
                            })))
                    .values());
        }
        return new ArrayList<>();
    }

    @Autowired
    public void setSmbShipperServiceClient(SmbShipperServiceClient smbShipperServiceClient) {
        this.smbShipperServiceClient = smbShipperServiceClient;
    }

}
