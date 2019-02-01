package com.gcloudapp.deviceHandler.persistence;

import com.gcloudapp.deviceHandler.model.Device;

import java.util.List;

public interface DataStore {

    long saveDevice(Device device);
    boolean isMacAdressPresent(String macAdress);
    Device getDevice(String macAdress);
    Device getDevice(int idDevice);
    List<Device> getAllDevices();
}
