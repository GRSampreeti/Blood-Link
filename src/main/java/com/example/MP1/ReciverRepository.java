package com.example.MP1;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.bson.types.ObjectId;

public interface ReciverRepository extends MongoRepository<Reciver, ObjectId>  {
}
