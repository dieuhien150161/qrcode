package com.qrcode.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	private String tendoanhnghiep;

	private String diachi;
	private String nganhkinhdoanh;
	private String daidiendoanhnghiep;
	private String chucvunguoidaidien;
	private String anhlogo;
	private String sodienthoai;
	private Integer usertype;

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

	public String getAnhlogo() {
		return anhlogo;
	}

	public void setAnhlogo(String anhlogo) {
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

	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<User> user = new HashSet<>();

	
	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public User() {
		
	}
	
	public User(UserBuilder userBuilder) {
		this.id = userBuilder.id;
		this.email = userBuilder.email;
		this.password = userBuilder.password;
		this.tendoanhnghiep = userBuilder.tendoanhnghiep;
		this.diachi = userBuilder.diachi;
		this.nganhkinhdoanh = userBuilder.nganhkinhdoanh;
		this.daidiendoanhnghiep = userBuilder.daidiendoanhnghiep;
		this.chucvunguoidaidien = userBuilder.chucvunguoidaidien;
		this.anhlogo = userBuilder.anhlogo;
		this.sodienthoai = userBuilder.sodienthoai;
		this.usertype = userBuilder.usertype;

	}
	public static class UserBuilder{
		private int id;
		private String email;
		private String password;
		private String tendoanhnghiep;
		private String diachi;
		private String nganhkinhdoanh;
		private String daidiendoanhnghiep;
		private String chucvunguoidaidien;
		private String anhlogo;
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
		public String getAnhlogo() {
			return anhlogo;
		}
		public void setAnhlogo(String anhlogo) {
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
		public UserBuilder(int id) {
	    	this.id = id;
	    }
		public UserBuilder email(String email) {
			this.email = email;
			return this;
		}
		public UserBuilder password(String password) {
			this.password = password;
			return this;
		}
		public UserBuilder tenDoanhnghiep(String tendoanhnghiep) {
			this.tendoanhnghiep = tendoanhnghiep;
			return this;
		}
		public UserBuilder diaChi(String diachi) {
        	this.diachi = diachi;
        	return this;
        }
		public UserBuilder nganhKinhDoanh(String nganhkinhdoanh) {
        	this.nganhkinhdoanh = nganhkinhdoanh;
        	return this;
        }
		public UserBuilder daiDienDoanhNghiep(String daidiendoanhnghiep) {
        	this.daidiendoanhnghiep = daidiendoanhnghiep;
        	return this;
        }
		public UserBuilder chucVuNguoiDaiDien(String chucvunguoidaidien) {
        	this.chucvunguoidaidien = chucvunguoidaidien;
        	return this;
        }
		public UserBuilder anhLogo(String anhlogo) {
			this.anhlogo = anhlogo;
			return this;
		}
		public UserBuilder soDienThoai(String sodienthoai) {
        	this.sodienthoai = sodienthoai;
        	return this;
        }
		public UserBuilder usertype(Integer usertype) {
        	this.usertype = usertype;
        	return this;
        }
		public User build() {
	    	return new User(this);
	    }
	}

}
