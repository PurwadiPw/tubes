package com.tubes.service;

import com.tubes.model.Hari;

public interface HariService {

    Iterable<Hari> listAllHaris();

    Hari getHariById(String id);

    Hari saveHari(Hari hari);

    void deleteHari(String id);
}
