package com.chyld.services;

import com.chyld.entities.Device;
import com.chyld.repositories.IDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {
    @Autowired
    IDeviceRepository deviceRepository;

    public Device saveDevice(Device exercise) { return deviceRepository.save(exercise); }

    public Device findById(int id) {
        return deviceRepository.findById(id);
    }

    public void deleteDevice(Device device) {
        deviceRepository.delete(device);
    }
}
