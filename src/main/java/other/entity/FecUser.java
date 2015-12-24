package other.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rc_hb")
public class FecUser {
	private String access_key;
	private Integer id;
	private String secret_key;
	private String userId;
	public String getAccess_key() {
		return access_key;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public String getSecret_key() {
		return secret_key;
	}
	public String getUserId() {
		return userId;
	}
	public void setAccess_key(String access_key) {
		this.access_key = access_key;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setSecret_key(String secret_key) {
		this.secret_key = secret_key;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "FecUser [access_key=" + access_key + ", id=" + id + ", secret_key=" + secret_key + ", userId=" + userId + "]";
	}

}
