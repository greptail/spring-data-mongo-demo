package com.journaldev.bootifulmongodb;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.journaldev.bootifulmongodb.dal.MachineRepository;
import com.journaldev.bootifulmongodb.model.Machine;
import com.journaldev.bootifulmongodb.model.MachineId;

@Component
public class Runner {

    @Autowired
    private MachineRepository machineRepository;

    @PostConstruct
    public void run() {
        machineRepository.deleteAll();
        Machine machine = new Machine();
        MachineId id = new MachineId();
        id.setName("m1");
        id.setVersion("v1");
        machine.setMachineId(id);
        machineRepository.save(machine);
        System.out.println("***********************Total m1 machines :"
                + machineRepository.findByMachineId_NameContainingIgnoreCase("m1").size() + "***********************");
    }
}
