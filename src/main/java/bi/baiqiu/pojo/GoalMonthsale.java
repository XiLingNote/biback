package bi.baiqiu.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * GMV月度计划实体
 * @author Administrator
 *
 */
@Table(name="pj_goal_month_sale")
public class GoalMonthsale implements Serializable {
    private Integer id;

    private String ex;

    private String ct;

    private String mt;
    
    @Column(name = "shop_id")
    private String shopId;

    private String y;

    private String m01;

    private String m02;

    private String m03;

    private String m04;

    private String m05;

    private String m06;

    private String m07;

    private String m08;

    private String m09;

    private String m10;

    private String m11;

    private String m12;

    private String remark;

    private String seq;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public String getMt() {
        return mt;
    }

    public void setMt(String mt) {
        this.mt = mt;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getM01() {
        return m01;
    }

    public void setM01(String m01) {
        this.m01 = m01;
    }

    public String getM02() {
        return m02;
    }

    public void setM02(String m02) {
        this.m02 = m02;
    }

    public String getM03() {
        return m03;
    }

    public void setM03(String m03) {
        this.m03 = m03;
    }

    public String getM04() {
        return m04;
    }

    public void setM04(String m04) {
        this.m04 = m04;
    }

    public String getM05() {
        return m05;
    }

    public void setM05(String m05) {
        this.m05 = m05;
    }

    public String getM06() {
        return m06;
    }

    public void setM06(String m06) {
        this.m06 = m06;
    }

    public String getM07() {
        return m07;
    }

    public void setM07(String m07) {
        this.m07 = m07;
    }

    public String getM08() {
        return m08;
    }

    public void setM08(String m08) {
        this.m08 = m08;
    }

    public String getM09() {
        return m09;
    }

    public void setM09(String m09) {
        this.m09 = m09;
    }

    public String getM10() {
        return m10;
    }

    public void setM10(String m10) {
        this.m10 = m10;
    }

    public String getM11() {
        return m11;
    }

    public void setM11(String m11) {
        this.m11 = m11;
    }

    public String getM12() {
        return m12;
    }

    public void setM12(String m12) {
        this.m12 = m12;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ex=").append(ex);
        sb.append(", ct=").append(ct);
        sb.append(", mt=").append(mt);
        sb.append(", shopId=").append(shopId);
        sb.append(", y=").append(y);
        sb.append(", m01=").append(m01);
        sb.append(", m02=").append(m02);
        sb.append(", m03=").append(m03);
        sb.append(", m04=").append(m04);
        sb.append(", m05=").append(m05);
        sb.append(", m06=").append(m06);
        sb.append(", m07=").append(m07);
        sb.append(", m08=").append(m08);
        sb.append(", m09=").append(m09);
        sb.append(", m10=").append(m10);
        sb.append(", m11=").append(m11);
        sb.append(", m12=").append(m12);
        sb.append(", remark=").append(remark);
        sb.append(", seq=").append(seq);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}