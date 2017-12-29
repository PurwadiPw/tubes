package com.tubes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ruang")
public class Ruang {
	
	@Id
	@Column(name = "KD_RUANG")
	private String KD_RUANG;
	
	@Column(name = "NM_RUANG")
	private String NM_RUANG;

	public String getKdRuang() {
		return KD_RUANG;
	}

	public void setKdRuang(String KdRuang) {
		this.KD_RUANG = KdRuang;
	}

	public String getNmRuang() {
		return NM_RUANG;
	}

	public void setNmRuang(String NmRuang) {
		this.NM_RUANG = NmRuang;
	}

}
