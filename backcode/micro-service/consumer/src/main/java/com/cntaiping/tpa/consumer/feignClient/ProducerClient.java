package com.cntaiping.tpa.consumer.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "producer", fallback = ProducerHystrix.class)
public interface ProducerClient {
    @GetMapping("/get")
    String getMessage(@RequestParam String name);
}
