package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName : FlowLimitController
 * @Author : 50316
 * @Date: 2021/7/28 23:04
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA(){
        return "--------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "--------testB";
    }

    @GetMapping("/testD")
    public  String testD(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("test 测试RT");
        return "-----testD";
    }

    @GetMapping("/testHotKey")
    // value 可以为任意值,但是为了编码的统一和规范使用的 rest 的地址
    // blockHandler 定义处理降级熔断的方法名称
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotkey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "------- testHotKey 成功";
    }

    // 要加入 BlockException
    public String deal_testHotkey(String p1, String p2, BlockException exception) {
        return "------ deal_testHotkey  降级";//sentinel系统默认的提示：Blocked by Sentinel (flow limiting)
    }

}
