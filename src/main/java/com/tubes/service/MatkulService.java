package com.tubes.service;

import com.tubes.model.Matkul;

public interface MatkulService {

    Iterable<Matkul> listAllMatkuls();

    Matkul getMatkulByKd(String kd);

    Matkul saveMatkul(Matkul matkul);

    void deleteMatkul(String kd);
}
