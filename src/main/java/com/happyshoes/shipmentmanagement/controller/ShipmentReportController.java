package com.happyshoes.shipmentmanagement.controller;

import com.happyshoes.shipmentmanagement.exception.RestExceptionHandler;
import com.happyshoes.shipmentmanagement.model.ShipmentReport;
import com.happyshoes.shipmentmanagement.service.ShipmentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shipment/report")
public class ShipmentReportController extends RestExceptionHandler {

    private ShipmentReportService shipmentReportService;

    @GetMapping
    public ResponseEntity<List<ShipmentReport>> getShipmentReport() {
        List<ShipmentReport> shipmentReports = shipmentReportService.getShipmentReport();
        return new ResponseEntity<>(shipmentReports, HttpStatus.OK);
    }

    @Autowired
    public void setShipmentReportService(ShipmentReportService shipmentReportService) {
        this.shipmentReportService = shipmentReportService;
    }

}
