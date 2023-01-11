package com.shop.controller;

import com.shop.pojo.ApiResponse;
import com.shop.pojo.CustomerRewardPojo;
import com.shop.service.RewardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/reward")
public class RewardController extends BaseController {

    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CustomerRewardPojo>>> getCustomerRewards() {
        return ResponseEntity.ok(successResponse("Customer rewards", rewardService.getRewardPoints()));
    }

}
