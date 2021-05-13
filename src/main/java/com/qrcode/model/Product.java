package com.qrcode.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.qrcode.domain.User;

@Entity
@Table(name="product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "ma_dn", nullable = false)
    private User user;
    private String tensanpham;
    private String xuatxu;
    private String thuonghieu;
    private String loaisanpham;
    private Double giaban;
    private Date ngaysanxuat;
    private Date hansudung;
    private String mota;
    @Transient
    private MultipartFile image1;
    private String hinhanh1;
    @Transient
    private MultipartFile image2;
    private String hinhanh2;
    private String anhqr;
    
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTensanpham() {
		return tensanpham;
	}
	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}
	public String getXuatxu() {
		return xuatxu;
	}
	public void setXuatxu(String xuatxu) {
		this.xuatxu = xuatxu;
	}
	public String getThuonghieu() {
		return thuonghieu;
	}
	public void setThuonghieu(String thuonghieu) {
		this.thuonghieu = thuonghieu;
	}
	public String getLoaisanpham() {
		return loaisanpham;
	}
	public void setLoaisanpham(String loaisanpham) {
		this.loaisanpham = loaisanpham;
	}
	public Double getGiaban() {
		return giaban;
	}
	public void setGiaban(Double giaban) {
		this.giaban = giaban;
	}
	public Date getNgaysanxuat() {
		return ngaysanxuat;
	}
	public void setNgaysanxuat(Date ngaysanxuat) {
		this.ngaysanxuat = ngaysanxuat;
	}
	public Date getHansudung() {
		return hansudung;
	}
	public void setHansudung(Date hansudung) {
		this.hansudung = hansudung;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getHinhanh1() {
		return hinhanh1;
	}
	public void setHinhanh1(String hinhanh1) {
		this.hinhanh1 = hinhanh1;
	}
	public String getHinhanh2() {
		return hinhanh2;
	}
	public void setHinhanh2(String hinhanh2) {
		this.hinhanh2 = hinhanh2;
	}
	public String getAnhqr() {
		return anhqr;
	}
	public void setAnhqr(String anhqr) {
		this.anhqr = anhqr;
	}
	
	
	public MultipartFile getImage1() {
		return image1;
	}
	public void setImage1(MultipartFile image1) {
		this.image1 = image1;
	}
	public MultipartFile getImage2() {
		return image2;
	}
	public void setImage2(MultipartFile image2) {
		this.image2 = image2;
	}
	public Product() {
		
	}
	
	public Product(ProductBuilder productBuilder) {
		this.id = productBuilder.id;
		this.tensanpham = productBuilder.tensanpham;
		this.xuatxu = productBuilder.xuatxu;
		this.thuonghieu = productBuilder.thuonghieu;
		this.loaisanpham = productBuilder.loaisanpham;
		this.giaban = productBuilder.giaban;
		this.ngaysanxuat = productBuilder.ngaysanxuat;
		this.hansudung = productBuilder.hansudung;
		this.mota = productBuilder.mota;
		this.hinhanh1 = productBuilder.hinhanh1;
		this.hinhanh2 = productBuilder.hinhanh2;
		this.anhqr = productBuilder.anhqr;
	}
	public static class ProductBuilder{
		private String id;
		private String tensanpham;
	    private String xuatxu;
	    private String thuonghieu;
	    private String loaisanpham;
	    private Double giaban;
	    private Date ngaysanxuat;
	    private Date hansudung;
	    private String mota;
	    private String hinhanh1;
	    private String hinhanh2;
	    private String anhqr;
	    private User user;
	    
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getTensanpham() {
			return tensanpham;
		}
		public void setTensanpham(String tensanpham) {
			this.tensanpham = tensanpham;
		}
		public String getXuatxu() {
			return xuatxu;
		}
		public void setXuatxu(String xuatxu) {
			this.xuatxu = xuatxu;
		}
		public String getThuonghieu() {
			return thuonghieu;
		}
		public void setThuonghieu(String thuonghieu) {
			this.thuonghieu = thuonghieu;
		}
		public String getLoaisanpham() {
			return loaisanpham;
		}
		public void setLoaisanpham(String loaisanpham) {
			this.loaisanpham = loaisanpham;
		}
		public Double getGiaban() {
			return giaban;
		}
		public void setGiaban(Double giaban) {
			this.giaban = giaban;
		}
		public Date getNgaysanxuat() {
			return ngaysanxuat;
		}
		public void setNgaysanxuat(Date ngaysanxuat) {
			this.ngaysanxuat = ngaysanxuat;
		}
		public Date getHansudung() {
			return hansudung;
		}
		public void setHansudung(Date hansudung) {
			this.hansudung = hansudung;
		}
		public String getMota() {
			return mota;
		}
		public void setMota(String mota) {
			this.mota = mota;
		}
		public String getHinhanh1() {
			return hinhanh1;
		}
		public void setHinhanh1(String hinhanh1) {
			this.hinhanh1 = hinhanh1;
		}
		public String getHinhanh2() {
			return hinhanh2;
		}
		public void setHinhanh2(String hinhanh2) {
			this.hinhanh2 = hinhanh2;
		}
		public String getAnhqr() {
			return anhqr;
		}
		public void setAnhqr(String anhqr) {
			this.anhqr = anhqr;
		}
	    public ProductBuilder(String id) {
	    	this.id = id;
	    }
	    public ProductBuilder tenSanPham(String tenSanPham) {
			this.tensanpham = tenSanPham;
			return this;
		}
	    public ProductBuilder xuatXu(String xuatXu) {
			this.xuatxu = xuatXu;
			return this;
		}
	    public ProductBuilder moTa(String moTa) {
			this.mota = moTa;
			return this;
		}

	    public ProductBuilder thuongHieu(String thuongHieu) {
			this.thuonghieu = thuongHieu;
			return this;
		}
	    public ProductBuilder loaiSanPham(String loaiSanPham) {
			this.loaisanpham = loaiSanPham;
			return this;
		}
	    public ProductBuilder giaBan(Double giaBan) {
			this.giaban = giaBan;
			return this;
		}
	    public ProductBuilder ngaySanXuat(Date ngaySanXuat) {
			this.ngaysanxuat = ngaySanXuat;
			return this;
		}
	    public ProductBuilder hanSuDung(Date hanSuDung) {
			this.hansudung = hanSuDung;
			return this;
		}
	    public ProductBuilder hinhAnh1(String hinhAnh1) {
			this.hinhanh1 = hinhAnh1;
			return this;
		}
	    public ProductBuilder hinhAnh2(String hinhAnh2) {
			this.hinhanh2 = hinhAnh2;
			return this;
		}
	    public ProductBuilder anhQr(String anhQr) {
			this.anhqr = anhQr;
			return this;
		}
		
	    public Product build() {
	    	return new Product(this);
	    }
	}
    
    
}
