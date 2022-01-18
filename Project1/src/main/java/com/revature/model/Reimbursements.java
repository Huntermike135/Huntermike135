package com.revature.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Reimbursements")
public class Reimbursements {
//	@Id
//	@Column(name = "employee_Name")
//	private String empUserName;
//	@GeneratedValue(generator = "request_id_seq", strategy = GenerationType.AUTO)
//	@SequenceGenerator(allocationSize = 1, name = "request_id_seq")
//	private int reimId;
//	@Column(name = "amount", columnDefinition = "NUMERIC")
//	private float amount;
//	@Column(name = "reason")
//	private String reason;
//	@Column(name = "status")
//	private String status;
//	@Column(name = "manager_ID")
//	private int manId;
	
	@Column
	private String empUserName;
	@Id
	@GeneratedValue(generator = "Reimbursement_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "reimbursement_id_seq")
	private int reimId;
	@Column
	private float amount;
	@Column
	private String reason;
	@Column
	private String status;
	@Column
	private int manId;
	
	public Reimbursements() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reimbursements(String empUserName, float amount, String reason) {
		super();
		this.empUserName = empUserName;
		this.amount = amount;
		this.reason = reason;
	}
	public Reimbursements(String empName, int reimId, float amount, String reason, String status, int manId) {
		super();
		this.empUserName = empName;
		this.reimId = reimId;
		this.amount = amount;
		this.reason = reason;
		this.status = status;
		this.manId = manId;
	}
	public String getEmpName() {
		return empUserName;
	}
	public void setEmpName(String empName) {
		this.empUserName = empName;
	}
	public int getReimId() {
		return reimId;
	}
	public void setReimId(int reimId) {
		this.reimId = reimId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getManId() {
		return manId;
	}
	public void setManId(int manId) {
		this.manId = manId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(amount, empUserName, manId, reason, reimId, status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursements other = (Reimbursements) obj;
		return Float.floatToIntBits(amount) == Float.floatToIntBits(other.amount)
				&& Objects.equals(empUserName, other.empUserName) && manId == other.manId
				&& Objects.equals(reason, other.reason) && reimId == other.reimId
				&& Objects.equals(status, other.status);
	}
	@Override
	public String toString() {
		return "Reimbursements [empName=" + empUserName + ", reimId=" + reimId + ", amount=" + amount + ", reason=" + reason
				+ ", status=" + status + ", manId=" + manId + "]";
	}

}