// BloodBankRepository.java

package com.example.MP1;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BloodBankRepository extends MongoRepository<BloodBank, ObjectId> {

    Optional<BloodBank> findBloodBankByStateAndDistrict(String state, String district);
    Optional<BloodBank> findBloodBankByBloodstream(String bloodstream);
    Optional<BloodBank> findBloodBankByStateAndDistrictAndBloodstream(String state, String district,String bloodstream);
}
