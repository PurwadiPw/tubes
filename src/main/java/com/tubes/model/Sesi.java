package com.tubes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sesi")
public class Sesi {
	
	@Id
	@Column(name = "ID_SESI")
	private Integer ID_SESI;
	
	@Column(name = "JAM_MULAI")
	private String JAM_MULAI;
	
	@Column(name = "JAM_Akhir")
	private String JAM_AKHIR;

	public Integer getIdSesi() {
		return ID_SESI;
	}

	public void setIdSesi(Integer IdSesi) {
		this.ID_SESI = IdSesi;
	}

	public String getJamMulai() {
		return JAM_MULAI;
	}

	public void setJamMulai(String JamMulai) {
		this.JAM_MULAI = JamMulai;
	}

	public String getJamAkhir() {
		return JAM_AKHIR;
	}

	public void setJamAkhir(String JamAkhir) {
		this.JAM_AKHIR = JamAkhir;
	}

}
