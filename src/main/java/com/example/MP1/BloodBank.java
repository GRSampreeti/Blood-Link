package com.example.MP1;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "bloodbank")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class BloodBank {
    @Id
    private ObjectId id;
    private String bloodstream;

    private String hospital;

    private String contactPerson;

    private String category;

    private String website;

    private String phone;

    private String email;

    private String state;

    private String district;

    private String address;

    private Map<String, Integer> bloodStock;



    public BloodBank(String bloodstream, String hospital, String contactPerson, String category, String website, String phone, String email, String state, String district, String address) {
        this.bloodstream = bloodstream;
        this.hospital = hospital;
        this.contactPerson = contactPerson;
        this.category = category;
        this.website = website;
        this.phone = phone;
        this.email = email;
        this.state = state;
        this.district = district;
        this.address = address;
    }
}
