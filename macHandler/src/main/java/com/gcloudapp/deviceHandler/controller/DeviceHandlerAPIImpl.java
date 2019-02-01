package com.gcloudapp.deviceHandler.controller;

import com.gcloudapp.deviceHandler.model.Device;
import com.gcloudapp.deviceHandler.persistence.DataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;
@RestController
@RequestMapping("/api")
public class DeviceHandlerAPIImpl implements DeviceHandlerAPI{

    @Autowired
    private DataStore dataStore;

    @Override
    public ResponseEntity saveDevice(final Device device) {
        Timestamp timestamp = new Timestamp(device.getTimestamp());
        Timestamp dateValid = Timestamp.valueOf("2018-01-01 00:00:00.0");

        if(timestamp.before(dateValid)){
            return new ResponseEntity(HttpStatus.PRECONDITION_FAILED);
        }
        if(dataStore.isMacAdressPresent(device.getMacAdress())){
            return new ResponseEntity(HttpStatus.PRECONDITION_FAILED);
        }
        dataStore.saveDevice(device);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    @ResponseBody
    public Device getDevice(final String macAdress) {
        return dataStore.getDevice(macAdress);
    }

    @Override
    @ResponseBody
    public Device getDevice(final int idDevice) {
        return dataStore.getDevice(idDevice);
    }

    @Override
    @ResponseBody
    public List<Device> getAllDevices() {
        return dataStore.getAllDevices();
    }
}
