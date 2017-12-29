package com.tubes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tubes.model.Jadwal;

import com.tubes.repository.JadwalRepository;

@Service
public class JadwalServiceImpl implements JadwalService{

    private JadwalRepository jadwalRepository;

    @Autowired
    public void setJadwalRepository(JadwalRepository jadwalRepository) {
        this.jadwalRepository = jadwalRepository;
    }

    @Override
    public Iterable<Jadwal> listAllJadwals() {
        return jadwalRepository.findAll();
    }

    @Override
    public Jadwal getJadwalByKd(String kd) {
        return jadwalRepository.findOne(kd);
    }

    @Override
    public Jadwal saveJadwal(Jadwal jadwal) {
        return jadwalRepository.save(jadwal);
    }

    @Override
    public void deleteJadwal(String kd) {
        jadwalRepository.delete(kd);
    }
}
