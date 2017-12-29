package com.tubes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dosen")
public class Dosen {
	
	@Id
	@Column(name = "KD_DOSEN")
	private String KD_DOSEN;
	
	@Column(name = "NM_DOSEN")
	private String NM_DOSEN;

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

}
