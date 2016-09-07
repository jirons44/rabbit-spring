package com.chyld.controllers;

import com.chyld.entities.Device;
import com.chyld.entities.Position;
import com.chyld.entities.Run;
import com.chyld.services.DeviceService;
import com.chyld.services.RunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/positions")
public class PositionController {

    @Autowired
    RunService runService;

    @Autowired
    DeviceService deviceService;


    @RequestMapping(value = "/{deviceId}", method = RequestMethod.POST)
    public Position createPosition(@PathVariable int deviceId, @RequestBody Position position) {
        Device device = deviceService.findById( deviceId );
        Run run = device.getStartedRun();
        position.setRun(run);
        run.getPositions().add(position);
        runService.saveRun(run);
        return position;
    }


}
