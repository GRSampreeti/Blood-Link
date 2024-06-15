package com.example.MP1;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class ReciverService {
    @Autowired
    private ReciverRepository reciverRepository;

    public List<Reciver> getAllRecivers() {
        return reciverRepository.findAll();
    }

    public Reciver saveReciver(Reciver reciver) {
        return reciverRepository.save(reciver);
    }

    public void deleteReciver(ObjectId id) {
        reciverRepository.deleteById(id);
    }

}
