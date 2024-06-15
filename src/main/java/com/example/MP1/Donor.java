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
        private String donorName;
        private String age;
        private String bloodgroup;
        private String units;
        private String gender;
        private String mobile;
        private String state;
        private String district;

        public Donor(String donorName, String age, String bloodgroup, String gender, String mobile, String units, String state, String district) {
            this.donorName = donorName;
            this.age = age;
            this.bloodgroup = bloodgroup;
            this.gender = gender;
            this.units = units;
            this.mobile = mobile;
            this.state = state;
            this.district = district;
        }
    }

