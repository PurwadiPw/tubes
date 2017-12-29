package com.tubes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hari")
public class Hari {
	
	@Id
	@Column(name = "ID_HARI")
	private String ID_HARI;
	
	@Column(name = "NM_HARI")
	private String NM_HARI;

	public String getIdHari() {
		return ID_HARI;
	}

	public void setIdHari(String IdHari) {
		this.ID_HARI = IdHari;
	}

	public String getNmHari() {
		return NM_HARI;
	}

	public void setNmHari(String NmHari) {
		this.NM_HARI = NmHari;
	}

}
