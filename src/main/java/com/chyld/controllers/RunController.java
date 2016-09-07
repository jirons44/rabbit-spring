package com.chyld.controllers;


import com.chyld.entities.Device;
import com.chyld.entities.Run;
import com.chyld.services.DeviceService;
import com.chyld.services.RunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/runs")
public class RunController {

    @Autowired
    RunService runService;

    @Autowired
    DeviceService deviceService;


@RequestMapping(value = "/{deviceId}", method = RequestMethod.POST)
public Run createRun(@RequestBody Run run, @PathVariable int deviceId) {

    Device device = deviceService.findById( deviceId );

    run.setDevice(device);


    return device;
}

}
