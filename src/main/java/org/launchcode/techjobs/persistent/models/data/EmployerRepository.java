package org.launchcode.techjobs.persistent.models.data;

import org.launchcode.techjobs.persistent.models.Employer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//had changed integer to long to get it to run correctly but then changed back
public interface EmployerRepository extends CrudRepository<Employer, Integer> {

//    void findbyID(int i);
//    void findById(int i);
//    Optional<Employer> findById(int i);
}
