package com.xiaotang.starrysky.controller;

import com.xiaotang.starrysky.model.mqtt.MqttPublish;
import com.xiaotang.starrysky.model.mqtt.Mymqtt;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 文件名: MqttController
 * 创建者: 友
 * 创建日期: 2020/10/22 9:27
 * 邮箱: 1738743304.com !
 * 描述: TODO
 */
@RestController
@RequestMapping("/mqtt")
public class MqttController {
    @Resource
    private Mymqtt mymqtt; //Mqtt实例

    /**
     * 主题的订阅（用于绑定设备id）
     * @param headers 请求信息
     * @param subscribe 订阅主题
     * @return 是否成功
     */
    @PostMapping("/subscribe")
    public String subscribe(@RequestHeader Map<String, String> headers, @RequestBody() String subscribe )
    {
       return mymqtt.subscribe(subscribe); //
    }

    /**
     * mqtt消息发送
     * @param headers 请求信息
     * @param publish MqttPublish 实例
     * @return

    @PostMapping("/publish")
    public String publish(@RequestHeader Map<String, String> headers, @RequestBody() MqttPublish publish)
    {
        return mymqtt.publish(publish.getPubTopic(),publish.getMsg());
    }
    */
}
