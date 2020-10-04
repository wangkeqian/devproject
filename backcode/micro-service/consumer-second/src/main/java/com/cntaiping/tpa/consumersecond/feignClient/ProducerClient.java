package com.cntaiping.tpa.consumersecond.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "producer", fallback = ProducerHystrix.class)
public interface ProducerClient {
    @GetMapping("/get")
    String getMessage(@RequestParam String name);
}
