package com.tubes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "matkul")
public class Matkul {
	
	@Id
	@Column(name = "KD_MATKUL")
	private String KD_MATKUL;
	
	@Column(name = "NM_MATKUL")
	private String NM_MATKUL;
	
	@Column(name = "JENIS")
	private String JENIS;
	
	@Column(name = "SKS")
	private Integer SKS;
	
    @Version
    private Integer VERSION;

	public String getKdMatkul() {
		return KD_MATKUL;
	}

	public void setKdMatkul(String KdMatkul) {
		this.KD_MATKUL = KdMatkul;
	}

	public String getNmMatkul() {
		return NM_MATKUL;
	}

	public void setNmMatkul(String NmMatkul) {
		this.NM_MATKUL = NmMatkul;
	}

	public String getJenis() {
		return JENIS;
	}

	public void setJenis(String Jenis) {
		this.JENIS = Jenis;
	}

	public Integer getSks() {
		return SKS;
	}

	public void setSks(Integer Sks) {
		this.SKS = Sks;
	}

    public Integer getVersion() {
        return VERSION;
    }

    public void setVersion(Integer version) {
        this.VERSION = version;
    }

}
