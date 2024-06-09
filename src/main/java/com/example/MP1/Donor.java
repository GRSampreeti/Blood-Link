package com.example.MP1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "donor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donor {

        @Id
        private ObjectId id;
        private String name;
        private String age;
        private String bloodgroup;
        private int units;
        private String gender;
        private String phone;
        private String state;
        private String district;

        public Donor(String name, String age, String bloodgroup, String gender, String phone, int units, String state, String district) {
            this.name = name;
            this.age = age;
            this.bloodgroup = bloodgroup;
            this.gender = gender;
            this.units = units;
            this.phone = phone;
            this.state = state;
            this.district = district;
        }
    }

