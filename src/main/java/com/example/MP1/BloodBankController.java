package com.example.MP1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/BloodLink")
public class BloodBankController {

    @Autowired
    private BloodBankService bloodBankService;

    @GetMapping("/getAll")
    public ResponseEntity<List<BloodBank>> getAllBloodBank()
    {
        return new ResponseEntity<List<BloodBank>>(bloodBankService.allBloodBank(), HttpStatus.OK);
    }

    @GetMapping("/allBanks/{state}/{district}")
    public ResponseEntity<Optional<BloodBank>> getspecificBloodBank(@PathVariable String state,@PathVariable String district)
    {
        return new ResponseEntity<Optional<BloodBank>>(bloodBankService.specificBloodBank(state,district),HttpStatus.OK);
    }

    @GetMapping("/allBanks/{bloodstream}")
    public ResponseEntity<Optional<BloodBank>> getspecificBloodBankbyName(@PathVariable String bloodstream)
    {
        return new ResponseEntity<Optional<BloodBank>>(bloodBankService.specificBloodBankName(bloodstream),HttpStatus.OK);
    }

    @PostMapping("/bloodbanks")
    public ResponseEntity<BloodBank> createBloodBank(@RequestBody Map<String, String> payload) {
        BloodBank bloodBank = bloodBankService.createBloodBank(
                payload.get("bloodstream"),
                payload.get("hospital"),
                payload.get("contactPerson"),
                payload.get("category"),
                payload.get("website"),
                payload.get("phone"),
                payload.get("email"),
                payload.get("state"),
                payload.get("district"),
                payload.get("address")

        );

        return ResponseEntity.ok(bloodBank);
    }

    @PutMapping("/donate/{state}/{district}/{bloodstream}/{bloodType}/{quantity}")
    public ResponseEntity<BloodBank> donateBloodGroup(@PathVariable String state,@PathVariable String district,@PathVariable String bloodstream,@PathVariable String bloodType,@PathVariable int quantity)
    {
        BloodBank updatedBloodBank = bloodBankService.donateBloodGroupCount(state, district, bloodstream, bloodType,quantity);
        return ResponseEntity.ok(updatedBloodBank);
    }

    @PutMapping("/receive/{state}/{district}/{bloodstream}/{bloodType}/{quantity}")
    public ResponseEntity<BloodBank> receiveBloodGroup(@PathVariable String state,@PathVariable String district,@PathVariable String bloodstream,@PathVariable String bloodType,@PathVariable int quantity)
    {
        BloodBank updatedBloodBank = bloodBankService.receiveBloodGroupCount(state, district, bloodstream, bloodType,quantity);
        return ResponseEntity.ok(updatedBloodBank);
    }
}
