package com.qrcode.domain;

import java.util.HashSet;

import org.springframework.web.multipart.MultipartFile;

public class UserForm {
	private int id;
	private String email;
	private String password;
	private String tendoanhnghiep;
	private String diachi;
	private String nganhkinhdoanh;
	private String daidiendoanhnghiep;
	private String chucvunguoidaidien;
	private MultipartFile anhlogo;
	private String sodienthoai;
	private Integer usertype;
	
	public UserForm() {
		
	}
	public UserForm(UserFormBuilder userFormBuilder) {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTendoanhnghiep() {
		return tendoanhnghiep;
	}

	public void setTendoanhnghiep(String tendoanhnghiep) {
		this.tendoanhnghiep = tendoanhnghiep;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getNganhkinhdoanh() {
		return nganhkinhdoanh;
	}

	public void setNganhkinhdoanh(String nganhkinhdoanh) {
		this.nganhkinhdoanh = nganhkinhdoanh;
	}

	public String getDaidiendoanhnghiep() {
		return daidiendoanhnghiep;
	}

	public void setDaidiendoanhnghiep(String daidiendoanhnghiep) {
		this.daidiendoanhnghiep = daidiendoanhnghiep;
	}

	public String getChucvunguoidaidien() {
		return chucvunguoidaidien;
	}

	public void setChucvunguoidaidien(String chucvunguoidaidien) {
		this.chucvunguoidaidien = chucvunguoidaidien;
	}

	public MultipartFile getAnhlogo() {
		return anhlogo;
	}

	public void setAnhlogo(MultipartFile anhlogo) {
		this.anhlogo = anhlogo;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public Integer getUsertype() {
		return usertype;
	}

	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}
	public static class UserFormBuilder{
		private int id;
		private String email;
		private String password;
		private String tendoanhnghiep;
		private String diachi;
		private String nganhkinhdoanh;
		private String daidiendoanhnghiep;
		private String chucvunguoidaidien;
		private MultipartFile anhlogo;
		private String sodienthoai;
		private Integer usertype;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getTendoanhnghiep() {
			return tendoanhnghiep;
		}
		public void setTendoanhnghiep(String tendoanhnghiep) {
			this.tendoanhnghiep = tendoanhnghiep;
		}
		public String getDiachi() {
			return diachi;
		}
		public void setDiachi(String diachi) {
			this.diachi = diachi;
		}
		public String getNganhkinhdoanh() {
			return nganhkinhdoanh;
		}
		public void setNganhkinhdoanh(String nganhkinhdoanh) {
			this.nganhkinhdoanh = nganhkinhdoanh;
		}
		public String getDaidiendoanhnghiep() {
			return daidiendoanhnghiep;
		}
		public void setDaidiendoanhnghiep(String daidiendoanhnghiep) {
			this.daidiendoanhnghiep = daidiendoanhnghiep;
		}
		public String getChucvunguoidaidien() {
			return chucvunguoidaidien;
		}
		public void setChucvunguoidaidien(String chucvunguoidaidien) {
			this.chucvunguoidaidien = chucvunguoidaidien;
		}
		public MultipartFile getAnhlogo() {
			return anhlogo;
		}
		public void setAnhlogo(MultipartFile anhlogo) {
			this.anhlogo = anhlogo;
		}
		public String getSodienthoai() {
			return sodienthoai;
		}
		public void setSodienthoai(String sodienthoai) {
			this.sodienthoai = sodienthoai;
		}
		public Integer getUsertype() {
			return usertype;
		}
		public void setUsertype(Integer usertype) {
			this.usertype = usertype;
		}
		public UserFormBuilder Id(int id) {
        	this.id = id;
        	return this;
        }
		public UserFormBuilder email(String email) {
        	this.email = email;
        	return this;
        }
		public UserFormBuilder password(String password) {
        	this.password = password;
        	return this;
        }
		public UserFormBuilder tenDoanhNghiep(String tendoanhnghiep) {
        	this.tendoanhnghiep = tendoanhnghiep;
        	return this;
        }
		public UserFormBuilder diaChi(String diachi) {
        	this.diachi = diachi;
        	return this;
        }
		public UserFormBuilder nganhKinhDoanh(String nganhkinhdoanh) {
        	this.nganhkinhdoanh = nganhkinhdoanh;
        	return this;
        }
		public UserFormBuilder daiDienDoanhNghiep(String daidiendoanhnghiep) {
        	this.daidiendoanhnghiep = daidiendoanhnghiep;
        	return this;
        }
		public UserFormBuilder chucVuNguoiDaiDien(String chucvunguoidaidien) {
        	this.chucvunguoidaidien = chucvunguoidaidien;
        	return this;
        }
		public UserFormBuilder anhLogo(MultipartFile anhlogo) {
			this.anhlogo = anhlogo;
			return this;
		}
		public UserFormBuilder soDienThoai(String sodienthoai) {
        	this.sodienthoai = sodienthoai;
        	return this;
        }
		public UserFormBuilder usertype(Integer usertype) {
        	this.usertype = usertype;
        	return this;
        }
		public UserForm build() {
        	return new UserForm(this);
        }
	}
	public void setRoles(HashSet<Role> roles) {
		this.setRoles(roles);
	}
}
