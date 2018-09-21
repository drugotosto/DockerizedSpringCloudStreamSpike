package com.ferrero.consumer;

import com.ferrero.consumer.events.GreetingsStreams;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(GreetingsStreams.class)
@SpringBootApplication
public class ConsumerApplication
{
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

}

