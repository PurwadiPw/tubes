package com.tubes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tubes.model.Dosen;

import com.tubes.repository.DosenRepository;

@Service
public class DosenServiceImpl implements DosenService{

    private DosenRepository dosenRepository;

    @Autowired
    public void setDosenRepository(DosenRepository dosenRepository) {
        this.dosenRepository = dosenRepository;
    }

    @Override
    public Iterable<Dosen> listAllDosens() {
        return dosenRepository.findAll();
    }

    @Override
    public Dosen getDosenByKd(String kd) {
        return dosenRepository.findOne(kd);
    }

    @Override
    public Dosen saveDosen(Dosen dosen) {
        return dosenRepository.save(dosen);
    }

    @Override
    public void deleteDosen(String kd) {
        dosenRepository.delete(kd);
    }
}
