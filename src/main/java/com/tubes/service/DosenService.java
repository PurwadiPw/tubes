package com.tubes.service;

import com.tubes.model.Dosen;

public interface DosenService {

    Iterable<Dosen> listAllDosens();

    Dosen getDosenByKd(String kd);

    Dosen saveDosen(Dosen dosen);

    void deleteDosen(String kd);
}
