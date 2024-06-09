// BloodBankService.java

package com.example.MP1;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Map;

@Service
public class BloodBankService {

    @Autowired
    private BloodBankRepository bloodBankRepository;

    public List<BloodBank> allBloodBank() {
        return bloodBankRepository.findAll();
    }

    public Optional<BloodBank> specificBloodBank(String state, String district) {
        return bloodBankRepository.findBloodBankByStateAndDistrict(state, district);
    }

    public Optional<BloodBank> specificBloodBankName(String bloodstream) {
        return bloodBankRepository.findBloodBankByBloodstream(bloodstream);
    }

    public BloodBank createBloodBank(String bloodstream, String hospital, String contactPerson, String category, String website, String phone, String email, String state, String district, String address) {
        // Create a new BloodBank object
        BloodBank bloodBank = new BloodBank(bloodstream, hospital, contactPerson, category, website, phone, email, state, district, address);

        // Initialize bloodStock with default values
        Map<String, Integer> bloodStock = new HashMap<>();
        bloodStock.put("A+", 0);
        bloodStock.put("A-", 0);
        bloodStock.put("B+", 0);
        bloodStock.put("B-", 0);
        bloodStock.put("AB+", 0);
        bloodStock.put("AB-", 0);
        bloodStock.put("O+", 0);
        bloodStock.put("O-", 0);

        // Set the bloodStock to the bloodBank object
        bloodBank.setBloodStock(bloodStock);

        // Save the bloodBank object
        return bloodBankRepository.save(bloodBank);
    }

    public BloodBank donateBloodGroupCount(String state,String district,String bloodstream,String bloodType,int quantity)
    {
        Optional<BloodBank> bloodBankOpt = bloodBankRepository.findBloodBankByStateAndDistrictAndBloodstream(state, district, bloodstream);
        if (bloodBankOpt.isPresent()) {
            BloodBank bloodBank = bloodBankOpt.get();
            Map<String, Integer> bloodStock = bloodBank.getBloodStock();
            bloodStock.put(bloodType, bloodStock.getOrDefault(bloodType, 0) + quantity);
            bloodBank.setBloodStock(bloodStock);
            return bloodBankRepository.save(bloodBank);
        } else {
            throw new ResourceNotFoundException("BloodBank not found for given state, district, and bloodstream");
        }
    }

    public BloodBank receiveBloodGroupCount(String state, String district, String bloodstream, String bloodType, int quantity)
    {
        Optional<BloodBank> bloodBankOpt = bloodBankRepository.findBloodBankByStateAndDistrictAndBloodstream(state, district, bloodstream);
        if (bloodBankOpt.isPresent()) {
            BloodBank bloodBank = bloodBankOpt.get();
            Map<String, Integer> bloodStock = bloodBank.getBloodStock();
            bloodStock.put(bloodType, bloodStock.getOrDefault(bloodType, 0) - quantity);
            bloodBank.setBloodStock(bloodStock);
            return bloodBankRepository.save(bloodBank);
        } else {
            throw new ResourceNotFoundException("BloodBank not found for given state, district, and bloodstream");
        }
    }
}
