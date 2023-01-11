package com.shop.controller;

import com.shop.pojo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    public ApiResponse successResponse(String message, Object data) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(message);
        apiResponse.setData(data);
        apiResponse.setStatus(true);
        return apiResponse;
    }

}
