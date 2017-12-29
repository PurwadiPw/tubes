package com.tubes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tubes.model.Kelas;

import com.tubes.repository.KelasRepository;

@Service
public class KelasServiceImpl implements KelasService{

    private KelasRepository kelasRepository;

    @Autowired
    public void setKelasRepository(KelasRepository kelasRepository) {
        this.kelasRepository = kelasRepository;
    }

    @Override
    public Iterable<Kelas> listAllKelass() {
        return kelasRepository.findAll();
    }

    @Override
    public Kelas getKelasByNm(String nm) {
        return kelasRepository.findOne(nm);
    }

    @Override
    public Kelas saveKelas(Kelas kelas) {
        return kelasRepository.save(kelas);
    }

    @Override
    public void deleteKelas(String nm) {
        kelasRepository.delete(nm);
    }
}
