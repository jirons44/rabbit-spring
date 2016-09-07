package com.chyld.controllers;


import com.chyld.entities.Device;
import com.chyld.entities.Run;
import com.chyld.services.DeviceService;
import com.chyld.services.RunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/runs")
public class RunController {

    @Autowired
    RunService runService;

    @Autowired
    DeviceService deviceService;


@RequestMapping(value = "/{deviceId}/start", method = RequestMethod.POST)
    public Run createRun(@PathVariable int deviceId) {
        Device device = deviceService.findById( deviceId );
        Run run = new Run();
        if (device.doesNotHaveCurrentRun()) {
            run.setDevice(device);
            device.getRuns().add(run);
            deviceService.saveDevice(device);
        }

        return run;
    }




@RequestMapping(value = "/{deviceId}/stop", method = RequestMethod.POST)
    public ResponseEntity stopRun(@PathVariable int deviceId) {
        Device device = deviceService.findById( deviceId );
        HttpStatus httpStatus = null;
        if (!device.doesNotHaveCurrentRun()) {
            device.stopRun();
            deviceService.saveDevice(device);
             httpStatus = HttpStatus.OK;
        } else {
             httpStatus = HttpStatus.I_AM_A_TEAPOT;
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity(null, httpHeaders, httpStatus);
    }

}