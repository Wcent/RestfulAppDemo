package org.cent.RestfulAppDemo.controller;

import org.cent.RestfulAppDemo.service.Greeting;
import org.cent.RestfulAppDemo.service.Result;
import org.cent.RestfulAppDemo.service.ResultStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Result greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Result(ResultStatus.SUCCESS,
                new Greeting(counter.incrementAndGet(), String.format(template, name)));
    }

    @GetMapping("/process")
    public Result process(@RequestParam(value = "number") double number) {
        return new Result(ResultStatus.SUCCESS, Greeting.process(number));
    }
}
