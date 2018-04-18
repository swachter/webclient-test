package eu.swdev.spring.webclienttest.client;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

@SpringBootApplication
public class Client implements CommandLineRunner {

    public static void main(String... args) {
        SpringApplication.run(Client.class);
    }

    @Autowired
    WebClient.Builder webClientBuilder;

    @Override
    public void run(String... args) throws Exception {
        val bytes = new byte[311];
        Arrays.fill(bytes, (byte)55);
        val result = webClientBuilder
                .build()
                .post()
                .uri("http://localhost:8080/handshake/step1")
                .body(BodyInserters.fromResource(new ByteArrayResource(bytes)))
                .retrieve()
                .bodyToMono(String.class)
                .block();
        System.out.println("result: " + result);
    }
}
