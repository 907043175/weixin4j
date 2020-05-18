package com.foxinmy.weixin4j.pay.payment.mch;

import com.alibaba.fastjson.annotation.JSONField;
import com.foxinmy.weixin4j.pay.type.mch.RefundChannel;
import com.foxinmy.weixin4j.xml.ListsuffixResult;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 退款申请结果
 * 
 * @className RefundResult
 * @author jinyu(foxinmy@gmail.com)
 * @date 2014年11月6日
 * @since JDK 1.6
 * @see
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RefundResult extends MerchantTradeResult {

	private static final long serialVersionUID = -3687863914168618620L;

	/**
	 * 商户退款单号
	 */
	@XmlElement(name = "out_refund_no")
	@JSONField(name = "out_refund_no")
	private String outRefundNo;
	/**
	 * 微信退款单号
	 */
	@XmlElement(name = "refund_id")
	@JSONField(name = "refund_id")
	private String refundId;
	/**
	 * 退款渠道:ORIGINAL—原路退款,默认 BALANCE—退回到余额
	 */
	@XmlElement(name = "refund_channel")
	@JSONField(name = "refund_channel")
	private String refundChannel;
	/**
	 * 退款总金额,单位为分,可以做部分退款
	 */
	@XmlElement(name = "refund_fee")
	@JSONField(name = "refund_fee")
	private int refundFee;
	/**
	 * 现金退款金额
	 */
	@XmlElement(name = "cash_refund_fee")
	@JSONField(name = "cash_refund_fee")
	private Integer cashRefundFee;
	/**
	 * 退款详情
	 * 
	 * @see RefundDetail
	 */
	@ListsuffixResult({ ".*(_\\d)$" })
	private List<RefundDetail> refundList;

	protected RefundResult() {
		// jaxb required
	}

	public String getOutRefundNo() {
		return outRefundNo;
	}

	public void setOutRefundNo(String outRefundNo) {
		this.outRefundNo = outRefundNo;
	}

	public String getRefundId() {
		return refundId;
	}

	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}

	public String getRefundChannel() {
		return refundChannel;
	}

	public void setRefundChannel(String refundChannel) {
		this.refundChannel = refundChannel;
	}

	@JSONField(serialize = false)
	public RefundChannel getFormatRefundChannel() {
		return refundChannel != null ? RefundChannel.valueOf(refundChannel
				.toUpperCase()) : null;
	}

	public int getRefundFee() {
		return refundFee;
	}

	public void setRefundFee(int refundFee) {
		this.refundFee = refundFee;
	}

	/**
	 * <font color="red">调用接口获取单位为分,get方法转换为元方便使用</font>
	 * 
	 * @return 元单位
	 */
	@JSONField(serialize = false)
	public double getFormatRefundFee() {
		return refundFee / 100d;
	}

	public Integer getCashRefundFee() {
		return cashRefundFee;
	}

	public void setCashRefundFee(Integer cashRefundFee) {
		this.cashRefundFee = cashRefundFee;
	}

	/**
	 * <font color="red">调用接口获取单位为分,get方法转换为元方便使用</font>
	 * 
	 * @return 元单位
	 */
	@JSONField(serialize = false)
	public double getFormatCashRefundFee() {
		return cashRefundFee != null ? cashRefundFee.intValue() / 100d : 0d;
	}

	public List<RefundDetail> getRefundList() {
		return refundList;
	}

	public void setRefundList(List<RefundDetail> refundList) {
		this.refundList = refundList;
	}

	@Override
	public String toString() {
		return "RefundResult [" + super.toString() + ", outRefundNo="
				+ outRefundNo + ", refundId=" + refundId + ", refundChannel="
				+ refundChannel + ", refundFee=" + refundFee
				+ ", cashRefundFee=" + cashRefundFee + ", refundList="
				+ refundList + "]";
	}
}
