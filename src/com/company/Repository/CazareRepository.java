package com.company.Repository;

import com.company.Domain.Cazare;
import com.company.Domain.CazareValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CazareRepository {
    private Map<Integer, Cazare> storage = new HashMap<>();
    private CazareValidator validator;


    public CazareRepository(CazareValidator validator) {
        this.validator = validator;
    }

    /**
     * @param cazare
     */
    public void add(Cazare cazare) {
        if (storage.containsKey(cazare.getId())) {
            throw new RuntimeException("O cazare cu acel Id exista deja!");
        }
        validator.validate(cazare);
        storage.put(cazare.getId(), cazare);
    }

    public void update(Cazare cazare) {
        if (storage.containsKey(cazare.getId())) {
            throw new RuntimeException("Nu exista o cazare cu acel Id pentru modificare!");
        }
        validator.validate(cazare);
        storage.put(cazare.getId(), cazare);
    }
    public List<Cazare> getAll(){
        return new ArrayList<>(storage.values());
    }
}
