package com.example.MP1;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.bson.types.ObjectId;

public interface DonorRepository extends MongoRepository<Donor, ObjectId> {
}
