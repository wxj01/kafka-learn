package com.wxj.kafka.kafkaprovider.controller;

import com.wxj.kafka.kafkaprovider.provider.KafkaSender;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/13 0013 13:56
 */

@RestController
public class KafkaController {

    @Autowired
    KafkaSender kafkaSender;

    @GetMapping("/sendMessageToKafka")
    public  String sendMessageToKafka() {
        Map<String,String> messageMap=new HashMap();
        messageMap.put("message","我是一条消息");
        String taskid="123456";
        String jsonStr= JSONObject.toJSONString(messageMap);
        //kakfa的推送消息方法有多种，可以采取带有任务key的，也可以采取不带有的（不带时默认为null）
//        kafkaSender.send("testTopic",taskid,jsonStr);
        kafkaSender.send("test001",taskid,jsonStr);

        return "hi kafka!";


    }
}