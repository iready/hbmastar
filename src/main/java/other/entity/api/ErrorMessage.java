package other.entity.api;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class ErrorMessage implements Serializable, Result {

	public Integer code;// 错误代码
	public String message;// 错误消息内容
	public String msg;// 错误消息内容（兼容旧版本）
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "assigned")
	public Integer getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public String getMsg() {
		return msg;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
