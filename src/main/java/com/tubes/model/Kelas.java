package com.tubes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kelas")
public class Kelas {
	
	@Id	
	@Column(name = "NM_KELAS")
	private String NM_KELAS;

	@Column(name = "PRODI")
	private String PRODI;

	public String getNmKelas() {
		return NM_KELAS;
	}

	public void setNmKelas(String NmKelas) {
		this.NM_KELAS = NmKelas;
	}

	public String getProdi() {
		return PRODI;
	}

	public void setProdi(String Prodi) {
		this.PRODI = Prodi;
	}

}
