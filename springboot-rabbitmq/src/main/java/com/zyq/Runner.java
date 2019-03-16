package com.zyq;

import java.util.concurrent.TimeUnit;

import com.zyq.message.Receiver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value=2)// 实现CommandLineRunner接口，run方法在程序启动的时候就执行，order注解用来表明顺序
public class Runner implements CommandLineRunner {

	private final RabbitTemplate rabbitTemplate;
	private final Receiver receiver;
	private final ConfigurableApplicationContext context;

	public Runner(Receiver receiver, RabbitTemplate rabbitTemplate, ConfigurableApplicationContext context) {
		this.receiver = receiver;
		this.rabbitTemplate = rabbitTemplate;
		this.context = context;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>服务启动执行 Runner1 <<<<<<<<<<<<<");
		System.out.println("Sending message...");
		rabbitTemplate.convertAndSend(RabbitMqApplication.queueName, "Hello from RabbitMQ!");
		receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
		context.close();
	}

	/**
	 * Sending message... 
	 * rabbitMq Received <Hello from RabbitMQ!>
	 */
}