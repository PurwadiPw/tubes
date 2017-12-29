package com.tubes.service;

import com.tubes.model.Sesi;

public interface SesiService {

    Iterable<Sesi> listAllSesis();

    Sesi getSesiById(Integer id);

    Sesi saveSesi(Sesi sesi);

    void deleteSesi(Integer id);
}
