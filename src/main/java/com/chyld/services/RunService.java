package com.chyld.services;

import com.chyld.entities.Run;
import com.chyld.repositories.IRunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunService {
    @Autowired
    IRunRepository runRepository;

    public void saveRun(Run run) {
        runRepository.save(run);
    }
}
