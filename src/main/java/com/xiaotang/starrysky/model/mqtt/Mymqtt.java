package com.xiaotang.starrysky.model.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 文件名: Mymqtt
 * 创建者: 友
 * 创建日期: 2020/10/8 14:26
 * 邮箱: 1738743304.com !
 * 描述: TODO
 */

@Component
@ConfigurationProperties(prefix = "mymqtt")
public class Mymqtt implements MqttCallback{


    private String HOST;  //主机地址 "tcp://134.175.221.21:1883"
    private String clientId; //ID 必须唯一 建议使用随机数
    private int qos; //消息质量 0~2
    private static MqttClient client;
    private MemoryPersistence persistence = new MemoryPersistence();
    public static String vaule = "";
    public Mymqtt(String HOST, String clientId, int qos) {
        this.HOST = HOST;
        this.clientId = clientId;
        this.qos = qos;
    }

    public String getHOST() {
        return HOST;
    }

    public void setHOST(String HOST) {
        this.HOST = HOST;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public int getQos() {
        return qos;
    }

    public void setQos(int qos) {
        this.qos = qos;
    }

    public Mymqtt() {

    }

    /**
     * 连接mqtt服务端
     */
    @PostConstruct
    void Connection() {
        try {
            if (client != null)
            {
                client.close();
            }
            client = new MqttClient(HOST, clientId, persistence);
            MqttConnectOptions connectOptions = new MqttConnectOptions();
            connectOptions.setUserName(clientId);
            connectOptions.setPassword("123456".toCharArray());
            connectOptions.setCleanSession(true);//保留会话
            connectOptions.setKeepAliveInterval(120);//设置心跳时间
            connectOptions.setConnectionTimeout(10);//设置超时时间 10s
            client.setCallback(this);//设置回调
            client.connect();//连接
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    /**
     * 订阅主题
     * @param subTopic 主题
     */
    public  String subscribe(String subTopic)
    {
        if (client != null)
        {
            try {
                client.subscribe(subTopic);
            } catch (MqttException e) {
                e.printStackTrace();
            }
            System.out.println("主题订阅成功");
        }
        return "主题订阅成功:"+subTopic;
    }
    private  String handerl(MqttMessage mqttMessage)
    {
        int id= mqttMessage.getId();
        return new String( mqttMessage.getPayload());
    }
    /**
     * 发送消息
     * @param pubTopic 主题
     * @param msg 内容
     */
    public String publish(String pubTopic,String msg)
    {
        MqttMessage mqttMessage = new MqttMessage(msg.getBytes());
        mqttMessage.setQos(qos);
        try {
            client.publish(pubTopic,mqttMessage);
            System.out.println(mqttMessage);
            System.out.println("主题:"+pubTopic+"消息是:"+msg);
        } catch (MqttException e) {
            e.printStackTrace();
        }
        return msg;
    }


    @Override
    public void connectionLost(Throwable throwable) {
         Connection(); //重连mqtt服务器
    }

    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        System.out.println("主题是"+topic);
        String msg = new String(mqttMessage.getPayload(),"GBK");
        System.out.println("消息是"+msg);
        System.out.println("主题质量"+mqttMessage.getQos());
        vaule = msg;
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        System.out.println("消息发送成功");
        try {
            System.out.println("发送的消息是："+iMqttDeliveryToken.getMessage());
            System.out.println("客户端：："+iMqttDeliveryToken.getClient());
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
