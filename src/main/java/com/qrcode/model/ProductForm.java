package com.qrcode.model;

import org.springframework.web.multipart.MultipartFile;

import com.qrcode.domain.User;

public class ProductForm {
	private String id;
	private String tensanpham;
    private String xuatxu;
    private String thuonghieu;
    private String loaisanpham;
    private Double giaban;
    private String ngaysanxuat;
    private String hansudung;
    private String mota;
    private MultipartFile hinhanh1;
    private MultipartFile hinhanh2;
    private MultipartFile anhqr;
    private User user;
    
    public ProductForm() {
    	
    }
    public ProductForm(ProductFormBuilder productFromBuilder) {
    	
    }

    
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
	public String getNgaysanxuat() {
		return ngaysanxuat;
	}
	public void setNgaysanxuat(String ngaysanxuat) {
		this.ngaysanxuat = ngaysanxuat;
	}
	public String getHansudung() {
		return hansudung;
	}
	public void setHansudung(String hansudung) {
		this.hansudung = hansudung;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public MultipartFile getHinhanh1() {
		return hinhanh1;
	}
	public void setHinhanh1(MultipartFile hinhanh1) {
		this.hinhanh1 = hinhanh1;
	}
	public MultipartFile getHinhanh2() {
		return hinhanh2;
	}
	public void setHinhanh2(MultipartFile hinhanh2) {
		this.hinhanh2 = hinhanh2;
	}
	public MultipartFile getAnhqr() {
		return anhqr;
	}
	public void setAnhqr(MultipartFile anhqr) {
		this.anhqr = anhqr;
	}
    
    public static class ProductFormBuilder{
    	private String id;
    	private String tensanpham;
        private String xuatxu;
        private String thuonghieu;
        private String loaisanpham;
        private Double giaban;
        private String ngaysanxuat;
        private String hansudung;
        private String mota;
        private MultipartFile hinhanh1;
        private MultipartFile hinhanh2;
        private MultipartFile anhqr;
        private User user;
        
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
		public String getNgaysanxuat() {
			return ngaysanxuat;
		}
		public void setNgaysanxuat(String ngaysanxuat) {
			this.ngaysanxuat = ngaysanxuat;
		}
		public String getHansudung() {
			return hansudung;
		}
		public void setHansudung(String hansudung) {
			this.hansudung = hansudung;
		}
		public String getMota() {
			return mota;
		}
		public void setMota(String mota) {
			this.mota = mota;
		}
		public MultipartFile getHinhanh1() {
			return hinhanh1;
		}
		public void setHinhanh1(MultipartFile hinhanh1) {
			this.hinhanh1 = hinhanh1;
		}
		public MultipartFile getHinhanh2() {
			return hinhanh2;
		}
		public void setHinhanh2(MultipartFile hinhanh2) {
			this.hinhanh2 = hinhanh2;
		}
		public MultipartFile getAnhqr() {
			return anhqr;
		}
		public void setAnhqr(MultipartFile anhqr) {
			this.anhqr = anhqr;
		}
        
        public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public ProductFormBuilder Id(String id) {
        	this.id = id;
        	return this;
        }
        public ProductFormBuilder user(User user) {
        	this.user = user;
        	return this;
        }
        public ProductFormBuilder tenSanPham(String tensanpham) {
        	this.tensanpham = tensanpham;
        	return this;
        }
        public ProductFormBuilder thuongHieu(String thuonghieu) {
        	this.thuonghieu = thuonghieu;
        	return this;
        }
        public ProductFormBuilder loaiSanPham(String loaisanpham) {
        	this.loaisanpham = loaisanpham;
        	return this;
        }
        
        public ProductFormBuilder giaBan(Double giaban) {
        	this.giaban = giaban;
        	return this;
        }
        public ProductFormBuilder ngaySanXuat(String ngaysanxuat) {
        	this.ngaysanxuat = ngaysanxuat;
        	return this;
        }
        public ProductFormBuilder hanSuDung(String hansudung) {
        	this.hansudung = hansudung;
        	return this;
        }
        public ProductFormBuilder moTa(String mota) {
        	this.mota = mota;
        	return this;
        }
        public ProductFormBuilder hinhAnh1(MultipartFile hinhanh1) {
			this.hinhanh1 = hinhanh1;
			return this;
		}
        public ProductFormBuilder hinhAnh2(MultipartFile hinhanh2) {
			this.hinhanh2 = hinhanh2;
			return this;
		}
        
        public ProductFormBuilder anhQr(MultipartFile anhqr) {
			this.anhqr = anhqr;
			return this;
		}
        public ProductForm build() {
        	return new ProductForm(this);
        }
    }
}
