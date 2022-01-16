package com.hatchways.response;


import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ResponseHandler {
    public static ResponseEntity<Map<String, String>> generateResponse(String status, String reason) {
        Map<String, String> map = new HashMap<String, String>();
            map.put("status", status);
            map.put("reason", reason);
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
}