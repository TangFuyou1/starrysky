package com.xiaotang.starrysky.model.mqtt;

/**
 * 文件名: MqttPublish
 * 创建者: 友
 * 创建日期: 2020/10/22 9:49
 * 邮箱: 1738743304.com !
 * 描述: TODO
 */
public class MqttPublish {
    private String pubTopic;
    private String msg;

    @Override
    public String toString() {
        return "MqttPublish{" +
                "pubTopic='" + pubTopic + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    public MqttPublish() {
    }

    public MqttPublish(String pubTopic, String msg) {
        this.pubTopic = pubTopic;
        this.msg = msg;
    }

    public String getPubTopic() {
        return pubTopic;
    }

    public void setPubTopic(String pubTopic) {
        this.pubTopic = pubTopic;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
