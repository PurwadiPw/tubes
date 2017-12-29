package com.tubes.service;

import com.tubes.model.Kelas;

public interface KelasService {

    Iterable<Kelas> listAllKelass();

    Kelas getKelasByNm(String nm);

    Kelas saveKelas(Kelas kelas);

    void deleteKelas(String nm);
}
