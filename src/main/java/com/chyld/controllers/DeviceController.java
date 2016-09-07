package com.chyld.controllers;

import com.chyld.entities.Device;
import com.chyld.entities.User;
import com.chyld.security.JwtToken;
import com.chyld.services.DeviceService;
import com.chyld.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Device createDevice(Principal user, @RequestBody Device device) {
        int uid = ((JwtToken)user).getUserId();
        User u = userService.findUserById(uid);
        device.setUser(u);
        u.getDevices().add(device);
        userService.saveUser(u);
        return device;
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Device> getDevices(Principal user) {
        int uid = ((JwtToken)user).getUserId();
        User u = userService.findUserById(uid);
        return u.getDevices();
    }





}
