package com.foxinmy.weixin4j.pay.payment.mch;

import com.alibaba.fastjson.annotation.JSONField;
import com.foxinmy.weixin4j.pay.type.mch.CorpPaymentCheckNameType;
import com.foxinmy.weixin4j.util.DateUtil;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * 企业付款记录
 * 
 * @className CorpPaymentRecord
 * @author jinyu(foxinmy@gmail.com)
 * @date 2015年6月23日
 * @since JDK 1.6
 * @see
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CorpPaymentRecord extends MerchantResult {

	private static final long serialVersionUID = -1926873539419750498L;

	/**
	 * 微信订单订单号
	 */
	@JSONField(name = "detail_id")
	@XmlElement(name = "detail_id")
	private String transactionId;
	/**
	 * 商户订单号
	 */
	@JSONField(name = "partner_trade_no")
	@XmlElement(name = "partner_trade_no")
	private String outTradeNo;
	/**
	 * 交易状态 SUCCESS:转账成功 FAILED:转账失败
	 */
	@JSONField(name = "status")
	@XmlElement(name = "status")
	private String transactionStatus;
	/**
	 * 如果失败则应该有原因
	 */
	@JSONField(name = "reason")
	@XmlElement(name = "reason")
	private String failureReason;
	/**
	 * 收款用户openid
	 */
	@JSONField(name = "openid")
	@XmlElement(name = "openid")
	private String openId;
	/**
	 * 收款用户姓名
	 */
	@JSONField(name = "transfer_name")
	@XmlElement(name = "transfer_name")
	private String transferName;
	/**
	 * 付款金额(单位为分)
	 */
	@JSONField(name = "payment_amount")
	@XmlElement(name = "payment_amount")
	private int paymentAmount;
	/**
	 * 转账时间
	 */
	@JSONField(name = "transfer_time")
	@XmlElement(name = "transfer_time")
	private String transferTime;
	/**
	 * 校验用户姓名选项
	 * 
	 * @see CorpPaymentCheckNameType
	 */
	@XmlElement(name = "check_name")
	@JSONField(name = "check_name")
	private String checkNameType;
	/**
	 * 企业付款描述信息
	 */
	@XmlElement(name = "desc")
	private String desc;
	/**
	 * 实名验证结果 PASS:通过 FAILED:不通过
	 */
	@JSONField(name = "check_name_result")
	@XmlElement(name = "check_name_result")
	private String checkNameResult;

	protected CorpPaymentRecord() {
		// jaxb required
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	/**
	 * 格式化交易状态
	 * 
	 * @return
	 */
	@JSONField(serialize = false)
	public boolean getFormatTransactionStatus() {
		return "success".equalsIgnoreCase(transactionStatus);
	}

	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getTransferName() {
		return transferName;
	}

	public void setTransferName(String transferName) {
		this.transferName = transferName;
	}

	public int getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	/**
	 * <font color="red">调用接口获取单位为分,get方法转换为元方便使用</font>
	 * 
	 * @return 元单位
	 */
	@JSONField(serialize = false)
	public double getFormatPaymentAmount() {
		return paymentAmount / 100d;
	}

	public String getTransferTime() {
		return transferTime;
	}

	public void setTransferTime(String transferTime) {
		this.transferTime = transferTime;
	}

	/**
	 * 格式化转账时间
	 * 
	 * @return
	 */
	@JSONField(serialize = false)
	public Date getFormatTransferTime() {
		return transferTime != null ? DateUtil
				.parse2yyyyMMddHHmmss(transferTime) : null;
	}

	public String getCheckNameType() {
		return checkNameType;
	}

	public void setCheckNameType(String checkNameType) {
		this.checkNameType = checkNameType;
	}

	@JSONField(serialize = false)
	public CorpPaymentCheckNameType getFormatCheckNameType() {
		return checkNameType != null ? CorpPaymentCheckNameType
				.valueOf(checkNameType) : null;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCheckNameResult() {
		return checkNameResult;
	}

	public void setCheckNameResult(String checkNameResult) {
		this.checkNameResult = checkNameResult;
	}

	/**
	 * 格式化交易状态
	 * 
	 * @return
	 */
	@JSONField(serialize = false)
	public boolean getFormatCheckNameResult() {
		return "pass".equalsIgnoreCase(checkNameResult);
	}

	@Override
	public String toString() {
		return "CorpPaymentRecord [transactionId=" + transactionId
				+ ", outTradeNo=" + outTradeNo + ", transactionStatus="
				+ getFormatTransactionStatus() + ", failureReason="
				+ failureReason + ", openId=" + openId + ", transferName="
				+ transferName + ", paymentAmount=" + getFormatPaymentAmount()
				+ ", transferTime=" + transferTime + ", checkNameType="
				+ checkNameType + ", desc=" + desc + ", checkNameResult="
				+ getFormatCheckNameResult() + ", " + super.toString() + "]";
	}
}
