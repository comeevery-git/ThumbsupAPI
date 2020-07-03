package com.boot.api.thumbsup.domains.brand.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_brand")
public class Brand {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer brandIdx;
    // 브랜드유형 
    private String brandType;

    // 브랜드구분 
    private String brandGrp;

    // 브랜드명 
    private String brandNm;

    // 대표자 
    private String brandOwner;

    // 대표 연락처 
    private String brandPhone;

    // 주소 
    private String brandAdd;

    // 상세주소 
    private String brandAddDtl;

    // 대표 이미지 
    private Integer brandImg;

    // 삭제유무 
    private String brandDelyn;

    // 등록일 
    private String brandRegdate;

    // 수정일 
    private String brandUpddate;

	public Integer getBrandIdx() {
		return brandIdx;
	}

	public void setBrandIdx(Integer brandIdx) {
		this.brandIdx = brandIdx;
	}

	public String getBrandType() {
		return brandType;
	}

	public void setBrandType(String brandType) {
		this.brandType = brandType;
	}

	public String getBrandGrp() {
		return brandGrp;
	}

	public void setBrandGrp(String brandGrp) {
		this.brandGrp = brandGrp;
	}

	public String getBrandNm() {
		return brandNm;
	}

	public void setBrandNm(String brandNm) {
		this.brandNm = brandNm;
	}

	public String getBrandOwner() {
		return brandOwner;
	}

	public void setBrandOwner(String brandOwner) {
		this.brandOwner = brandOwner;
	}

	public String getBrandPhone() {
		return brandPhone;
	}

	public void setBrandPhone(String brandPhone) {
		this.brandPhone = brandPhone;
	}

	public String getBrandAdd() {
		return brandAdd;
	}

	public void setBrandAdd(String brandAdd) {
		this.brandAdd = brandAdd;
	}

	public String getBrandAddDtl() {
		return brandAddDtl;
	}

	public void setBrandAddDtl(String brandAddDtl) {
		this.brandAddDtl = brandAddDtl;
	}

	public Integer getBrandImg() {
		return brandImg;
	}

	public void setBrandImg(Integer brandImg) {
		this.brandImg = brandImg;
	}

	public String getBrandDelyn() {
		return brandDelyn;
	}

	public void setBrandDelyn(String brandDelyn) {
		this.brandDelyn = brandDelyn;
	}

	public String getBrandRegdate() {
		return brandRegdate;
	}

	public void setBrandRegdate(String brandRegdate) {
		this.brandRegdate = brandRegdate;
	}

	public String getBrandUpddate() {
		return brandUpddate;
	}

	public void setBrandUpddate(String brandUpddate) {
		this.brandUpddate = brandUpddate;
	}

	@Override
	public String toString() {
		return "Brand [brandIdx=" + brandIdx + ", brandType=" + brandType + ", brandGrp=" + brandGrp + ", brandNm="
				+ brandNm + ", brandOwner=" + brandOwner + ", brandPhone=" + brandPhone + ", brandAdd=" + brandAdd
				+ ", brandAddDtl=" + brandAddDtl + ", brandImg=" + brandImg + ", brandDelyn=" + brandDelyn
				+ ", brandRegdate=" + brandRegdate + ", brandUpddate=" + brandUpddate + "]";
	}

	public Brand(Integer brandIdx, String brandType, String brandGrp, String brandNm, String brandOwner,
			String brandPhone, String brandAdd, String brandAddDtl, Integer brandImg, String brandDelyn,
			String brandRegdate, String brandUpddate) {
		super();
		this.brandIdx = brandIdx;
		this.brandType = brandType;
		this.brandGrp = brandGrp;
		this.brandNm = brandNm;
		this.brandOwner = brandOwner;
		this.brandPhone = brandPhone;
		this.brandAdd = brandAdd;
		this.brandAddDtl = brandAddDtl;
		this.brandImg = brandImg;
		this.brandDelyn = brandDelyn;
		this.brandRegdate = brandRegdate;
		this.brandUpddate = brandUpddate;
	}

    
    
    
    
    
    
}
