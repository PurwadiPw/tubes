package com.tubes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tubes.model.Hari;

import com.tubes.repository.HariRepository;

@Service
public class HariServiceImpl implements HariService{

    private HariRepository hariRepository;

    @Autowired
    public void setHariRepository(HariRepository hariRepository) {
        this.hariRepository = hariRepository;
    }

    @Override
    public Iterable<Hari> listAllHaris() {
        return hariRepository.findAll();
    }

    @Override
    public Hari getHariById(String id) {
        return hariRepository.findOne(id);
    }

    @Override
    public Hari saveHari(Hari hari) {
        return hariRepository.save(hari);
    }

    @Override
    public void deleteHari(String id) {
        hariRepository.delete(id);
    }
}
