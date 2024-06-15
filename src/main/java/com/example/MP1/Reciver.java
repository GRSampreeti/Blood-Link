package com.example.MP1;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "reciver")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Reciver {

    @Id
    private ObjectId id;
    private String patientName;
    private String age;
    private String bloodgroup;
    private String units;
    private String gender;
    private String reason;
    private String state;
    private String district;

    public Reciver(String patientName, String age, String bloodgroup, String gender, String reason, String units, String state, String district) {
        this.patientName = patientName;
        this.age = age;
        this.bloodgroup = bloodgroup;
        this.gender = gender;
        this.units = units;
        this.reason = reason;
        this.state = state;
        this.district = district;
    }

}
