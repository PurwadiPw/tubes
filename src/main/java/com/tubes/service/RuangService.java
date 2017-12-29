package com.tubes.service;

import com.tubes.model.Ruang;

public interface RuangService {

    Iterable<Ruang> listAllRuangs();

    Ruang getRuangByKd(String kd);

    Ruang saveRuang(Ruang ruang);

    void deleteRuang(String kd);
}
