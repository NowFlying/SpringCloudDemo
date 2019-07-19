package com.ggf.rejectdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.AmqpMessageReturnedException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.*;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@SpringBootApplication
@EnableBinding(RejectdemoApplication.TestTopic.class)
public class RejectdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RejectdemoApplication.class, args);
	}

	@org.springframework.web.bind.annotation.RestController
	static class  RestController {

		@Resource
		private TestTopic testTopic;


		/**
		 *  消息生产接口
		 *
		 * @Date 2019-07-09 9:45
		 * @param
		 * @return
		 **/
		@GetMapping("sendMessage")
		public String sendMessage(@RequestParam String message){
			testTopic.output().send(MessageBuilder.withPayload(message).build());
			return "success";
		}

	}

	@Slf4j
	@Component
	static class TestListener {

		int couter = 1;

		@StreamListener(TestTopic.INPUT)
		public void receive(String payload){
			log.info("receive" + payload + "第" + couter  +  "次");
			if(couter == 3){
				throw new AmqpRejectAndDontRequeueException("tried 3 times failed, send to dlq!");
			} else {
				couter++;
				throw new RuntimeException("Message consumer failed!");
			}

		}

	}



	interface TestTopic {

		String OUTPUT = "example-topic-output";
		String INPUT = "example-topic-input";

		@Output(OUTPUT)
		MessageChannel output();

		@Input(INPUT)
		SubscribableChannel input();

	}
}
