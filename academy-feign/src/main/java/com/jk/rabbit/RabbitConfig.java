package com.jk.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    /**
     *创建一个order 消息队列
     * 消息队列的顺序为 先入先出 FIFO
     * @return
     */
    @Bean
    public Queue creatQueue(){
        return new Queue("order");
    }
}
