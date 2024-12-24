package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDateTime;

@RestController
public class DemoController {
  @GetMapping("/demo")
  public String demo(final HttpServletRequest request) {
    final String protocol = request.getProtocol();
    System.out.println("/demo protocol: " + protocol);
    return "Hello World";
  }

  @GetMapping("/demo/sse")
  public Flux<ServerSentEvent<String>> sse(final HttpServletRequest request) {
    final String protocol = request.getProtocol();
    System.out.println("/demo/sse protocol: " + protocol);
    return Flux.interval(Duration.ofSeconds(1))
        .map(seq -> ServerSentEvent.<String>builder()
            .event("update")
            .data("timestamp is " + LocalDateTime.now())
            .build());
  }
}
