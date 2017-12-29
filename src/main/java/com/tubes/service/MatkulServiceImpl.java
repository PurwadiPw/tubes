package com.tubes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tubes.model.Matkul;

import com.tubes.repository.MatkulRepository;

@Service
public class MatkulServiceImpl implements MatkulService{

    private MatkulRepository matkulRepository;

    @Autowired
    public void setMatkulRepository(MatkulRepository matkulRepository) {
        this.matkulRepository = matkulRepository;
    }

    @Override
    public Iterable<Matkul> listAllMatkuls() {
        return matkulRepository.findAll();
    }

    @Override
    public Matkul getMatkulByKd(String kd) {
        return matkulRepository.findOne(kd);
    }

    @Override
    public Matkul saveMatkul(Matkul matkul) {
        return matkulRepository.save(matkul);
    }

    @Override
    public void deleteMatkul(String kd) {
        matkulRepository.delete(kd);
    }
}
