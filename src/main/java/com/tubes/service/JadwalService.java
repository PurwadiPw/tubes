package com.tubes.service;

import com.tubes.model.Jadwal;

public interface JadwalService {

    Iterable<Jadwal> listAllJadwals();

    Jadwal getJadwalByKd(String kd);

    Jadwal saveJadwal(Jadwal hari);

    void deleteJadwal(String kd);
}
