package com.shop.pojo;

import java.util.Map;

public class CustomerRewardPojo {

    private String customerId;

    private Map<String, Integer> rewards;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Map<String, Integer> getRewards() {
        return rewards;
    }

    public void setRewards(Map<String, Integer> rewards) {
        this.rewards = rewards;
    }
}
