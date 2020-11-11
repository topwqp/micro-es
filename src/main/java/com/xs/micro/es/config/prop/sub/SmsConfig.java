package com.xs.micro.es.config.prop.sub;

/**
 * @author wangqiupeng
 * @description: 短信服务配置
 * @date 2019-10-21 2:57 下午
 */
public class SmsConfig {
    /**
     * 国家代码
     */
    private String countryCode;
    /**
     * 账号
     **/
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 发送短信Url
     */
    private String sendSmsUrl;

    /**
     * 群发短信Url
     */
    private String batchSendSmsUrl;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSendSmsUrl() {
        return sendSmsUrl;
    }

    public void setSendSmsUrl(String sendSmsUrl) {
        this.sendSmsUrl = sendSmsUrl;
    }

    public String getBatchSendSmsUrl() {
        return batchSendSmsUrl;
    }

    public void setBatchSendSmsUrl(String batchSendSmsUrl) {
        this.batchSendSmsUrl = batchSendSmsUrl;
    }

    @Override
    public String toString() {
        return "SmsConfig{" +
                "countryCode='" + countryCode + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", sendSmsUrl='" + sendSmsUrl + '\'' +
                ", batchSendSmsUrl='" + batchSendSmsUrl + '\'' +
                '}';
    }
}
