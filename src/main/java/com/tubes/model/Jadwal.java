package com.tubes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "jadwal")
public class Jadwal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "KD_JADWAL")
	private String KD_JADWAL;
    
	@Column(name = "KD_MATKUL")
	private String KD_MATKUL;
    
	@Column(name = "JENIS")
	private String JENIS;
    
	@Column(name = "KD_DOSEN")
	private String KD_DOSEN;
	
	@Column(name = "NM_DOSEN")
	private String NM_DOSEN;
    
	@Column(name = "KD_RUANG")
	private String KD_RUANG;
    
	@Column(name = "TAHUN")
	private String TAHUN;
    
	@Column(name = "NM_KELAS")
	private String NM_KELAS;
    
	@Column(name = "ID_SESI")
	private String ID_SESI;
    
	@Column(name = "ID_HARI")
	private String ID_HARI;

    public Integer getKdJadwal() {
        return KD_JADWAL;
    }

    public void setKdJadwal(Integer KdJadwal) {
        this.KD_JADWAL = KdJadwal;
    }

	public String getKdDosen() {
		return KD_DOSEN;
	}

	public void setKdDosen(String KdDosen) {
		this.KD_DOSEN = KdDosen;
	}

	public String getNmDosen() {
		return NM_DOSEN;
	}

	public void setNmDosen(String NmDosen) {
		this.NM_DOSEN = NmDosen;
	}

	public String getKdRuang() {
		return KD_RUANG;
	}

	public void setKdRuang(String KdRuang) {
		this.KD_RUANG = KdRuang;
	}

	public String getKdRuang() {
		return KD_RUANG;
	}

	public void setKdRuang(String KdRuang) {
		this.KD_RUANG = KdRuang;
	}

	public String getTahun() {
		return TAHUN;
	}

	public void setTahun(String Tahun) {
		this.TAHUN = Tahun;
	}

	public String getNmKelas() {
		return NM_KELAS;
	}

	public void setNmKelas(String NmKelas) {
		this.NM_KELAS = NmKelas;
	}

	public String getIdSesi() {
		return ID_SESI;
	}

	public void setIdSesi(String IdSesi) {
		this.ID_SESI = IdSesi;
	}

	public String getIdHari() {
		return ID_HARI;
	}

	public void setIdHari(String IdHari) {
		this.ID_HARI = IdHari;
	}

}
