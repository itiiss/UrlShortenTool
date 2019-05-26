package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.service.shortUrlService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/url")
public class ShortUrlController {
    @Autowired
    private shortUrlService shortUrlService;

    @RequestMapping("/shortToLong")
    public Result shortToLong(String url) {
        Result result = new Result();
        try {
            String data= shortUrlService.shortToLong(url);
            if(data != null) {
                result.setData(data);
                result.setSuccess(true);
            } else {
                result.setData("未找到对应网址");
                result.setSuccess(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/longToShort")
    public Result longToShort(String url) {
        Result result = new Result();
        try {
            result.setData(shortUrlService.longToShort(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
