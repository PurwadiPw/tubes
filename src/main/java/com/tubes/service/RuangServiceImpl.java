package com.tubes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tubes.model.Ruang;

import com.tubes.repository.RuangRepository;

@Service
public class RuangServiceImpl implements RuangService{

    private RuangRepository ruangRepository;

    @Autowired
    public void setRuangRepository(RuangRepository ruangRepository) {
        this.ruangRepository = ruangRepository;
    }

    @Override
    public Iterable<Ruang> listAllRuangs() {
        return ruangRepository.findAll();
    }

    @Override
    public Ruang getRuangByKd(String kd) {
        return ruangRepository.findOne(kd);
    }

    @Override
    public Ruang saveRuang(Ruang ruang) {
        return ruangRepository.save(ruang);
    }

    @Override
    public void deleteRuang(String kd) {
        ruangRepository.delete(kd);
    }
}
