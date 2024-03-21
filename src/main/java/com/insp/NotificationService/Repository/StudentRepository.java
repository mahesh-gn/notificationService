package com.insp.NotificationService.Repository;

import com.insp.NotificationService.Dto.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student,Integer> {

}
