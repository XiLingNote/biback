package bi.baiqiu.pojo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "jdp_fx_trade")
public class JdpFxTrade implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "fenxiao_id")
	private BigInteger fenxiaoId;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "tc_order_id")
	private String tcOrderId;
	
	@Column(name = "supplier_username")
	private String supplierUsername;
	
	@Column(name = "distributor_username")
	private String distributorUsername;
	
	@Column(name = "created")
	private Date created;
	
	@Column(name = "modified")
	private Date modified;
	
	@Column(name = "jdp_hashcode")
	private String jdpHashcode;
	
	@Column(name = "jdp_modified")
	private Date jdpModified;
	
	@Column(name = "jdp_created")
	private Date jdpCreated;
	
	@Column(name = "jdp_response")
	private String jdpResponse;

	public String getMoney() {
		String[] order = this.jdpResponse.split("\"total_fee\":\"");
		String[] containsPrice = order[2].split("\"");
		String price = containsPrice[0]; 
		return price;
	}
	
	public BigInteger getFenxiaoId() {
		return fenxiaoId;
	}

	public void setFenxiaoId(BigInteger fenxiaoId) {
		this.fenxiaoId = fenxiaoId;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getTcOrderId() {
		return tcOrderId;
	}

	public void setTcOrderId(String tcOrderId) {
		this.tcOrderId = tcOrderId;
	}

	/**
	 * 店铺名称
	 * @return
	 */
	public String getSupplierUsername() {
		return supplierUsername;
	}

	public void setSupplierUsername(String supplierUsername) {
		this.supplierUsername = supplierUsername;
	}

	public String getDistributorUsername() {
		return distributorUsername;
	}

	public void setDistributorUsername(String distributorUsername) {
		this.distributorUsername = distributorUsername;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getJdpHashcode() {
		return jdpHashcode;
	}

	public void setJdpHashcode(String jdpHashcode) {
		this.jdpHashcode = jdpHashcode;
	}

	public Date getJdpModified() {
		return jdpModified;
	}

	public void setJdpModified(Date jdpModified) {
		this.jdpModified = jdpModified;
	}

	public Date getJdpCreated() {
		return jdpCreated;
	}

	public void setJdpCreated(Date jdpCreated) {
		this.jdpCreated = jdpCreated;
	}
			
	/**
	 * 订单信息
	 * @return
	 */
	public String getJdpResponse() {
		return jdpResponse;
	}

	public void setJdpResponse(String jdpResponse) {
		this.jdpResponse = jdpResponse;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", fenxiaoId=").append(fenxiaoId);
		sb.append(", status=").append(status);
		sb.append(", tcOrderId=").append(tcOrderId);
		sb.append(", supplierUsername=").append(supplierUsername);
		sb.append(", distributorUsername=").append(distributorUsername);
		sb.append(", created=").append(created);
		sb.append(", modified=").append(modified);
		sb.append(", jdpHashcode=").append(jdpHashcode);
		sb.append(", jdpModified=").append(jdpModified);
		sb.append(", jdpCreated=").append(jdpCreated);
		sb.append(", jdpResponse=").append(jdpResponse);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}