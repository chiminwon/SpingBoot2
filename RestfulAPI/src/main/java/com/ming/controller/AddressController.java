package com.ming.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Value(("classpath:data/exactMatch.json"))
    private Resource exactMatch;

    @GetMapping("/verify")
    public String verify() {
        JSONObject exactMatchJson = new JSONObject();
        exactMatchJson.put("MessageCode","ExactMatch");
        JSONObject addressJson = new JSONObject();
        addressJson.put("Addr1","1 S Roselle Rd ");
        addressJson.put("City","Schaumburg");
        addressJson.put("StateProvCd","IL");
        addressJson.put("PostalCode","60193");
        addressJson.put("Plus4","1638");
        addressJson.put("County","County");
        exactMatchJson.put("Addr",addressJson);
        return exactMatchJson.toJSONString();
    }

    //@PostMapping("/verify")
    public String autocomplete() {
        return "";
    }
}