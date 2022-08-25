package com.journaldev.bootifulmongodb.dal;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.journaldev.bootifulmongodb.model.Machine;

@Repository
public interface MachineRepository extends MongoRepository<Machine, String> {

    List<Machine> findByMachineId_Name(String name);

    @Query("{'_id.name':{$regex:?0, $options:'i'}}")
    List<Machine> findByMachineId_NameContainingIgnoreCase(String name, Pageable page);

    @Query("{'_id.name':{$regex:?0, $options:'i'}}")
    List<Machine> findByMachineId_NameContainingIgnoreCase(String name);

    @Query("{'_id.name':{$regex:'^?0$', $options:'i'},'_id.verion':{$regex:'^?1$',$options:'i'}}")
    List<Machine> findByMachineId_NameContainingIgnoreCaseAndMachineId_VersionContainingIgnoreCase(String name, Pageable page);

}
