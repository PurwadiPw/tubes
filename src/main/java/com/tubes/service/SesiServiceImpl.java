package com.tubes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tubes.model.Sesi;

import com.tubes.repository.SesiRepository;

@Service
public class SesiServiceImpl implements SesiService{

    private SesiRepository sesiRepository;

    @Autowired
    public void setSesiRepository(SesiRepository sesiRepository) {
        this.sesiRepository = sesiRepository;
    }

    @Override
    public Iterable<Sesi> listAllSesis() {
        return sesiRepository.findAll();
    }

    @Override
    public Sesi getSesiById(Integer id) {
        return sesiRepository.findOne(id);
    }

    @Override
    public Sesi saveSesi(Sesi sesi) {
        return sesiRepository.save(sesi);
    }

    @Override
    public void deleteSesi(Integer id) {
        sesiRepository.delete(id);
    }
}
