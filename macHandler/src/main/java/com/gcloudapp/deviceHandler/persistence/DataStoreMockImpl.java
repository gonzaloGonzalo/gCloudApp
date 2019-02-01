package com.gcloudapp.deviceHandler.persistence;

import com.gcloudapp.deviceHandler.model.Device;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DataStoreMockImpl implements DataStore{

    @Override
    public long saveDevice(Device device) {
        return 1;
    }

    @Override
    public boolean isMacAdressPresent(String macAdress) {
        return false;
    }

    @Override
    public Device getDevice(String macAdress) {
        return new Device(1, "fa:fa:fa:fa:fa:fa", 1548973702L);
    }

    @Override
    public Device getDevice(int idDevice) {
        return new Device(1, "fa:fa:fa:fa:fa:fa", 1548973702L);
    }

    @Override
    public List<Device> getAllDevices() {
        Device device = new Device(1, "fa:fa:fa:fa:fa:fa", 1548973702L);
       return Collections.singletonList(device);
    }
}
