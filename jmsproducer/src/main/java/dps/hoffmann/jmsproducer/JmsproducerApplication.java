package dps.hoffmann.jmsproducer;

import dps.hoffmann.jmsproducer.service.JmsQueueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class JmsproducerApplication implements CommandLineRunner {

 	@Autowired
	private JmsQueueService jmsQueueService;

	public static void main(String[] args) {
		SpringApplication.run(JmsproducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("append message");
		if (args.length != 2) {
			log.error("one arg expected - message");
			return;
		}
		jmsQueueService.sendMessage(args[0], args[1]);
	}
}
