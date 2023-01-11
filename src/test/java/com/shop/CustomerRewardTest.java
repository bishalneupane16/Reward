package com.shop;

import com.shop.model.Transaction;
import com.shop.service.RewardService;
import com.shop.service.impl.RewardServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class CustomerRewardTest {

    @Test
    public void calculateRewardPointTest() {
        RewardServiceImpl rewardService = new RewardServiceImpl();
        Map<String, Integer> response = rewardService.calculateRewardPoints(buildTestDataSet());
        Assert.assertEquals(response.get("OCT"), Integer.valueOf(20));
        Assert.assertEquals(response.get("NOV"), Integer.valueOf(190));
        Assert.assertEquals(response.get("DEC"), Integer.valueOf(0));
        Assert.assertEquals(response.get("Total"), Integer.valueOf(210));
    }

    public List<Transaction> buildTestDataSet() {
        List<Transaction> transactionList = new ArrayList<>();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            transactionList.add(new Transaction("1", 70D, dateFormat.parse("2022-10-05")));
            transactionList.add(new Transaction("1", 170D, dateFormat.parse("2022-11-05")));
            transactionList.add(new Transaction("1", 10D, dateFormat.parse("2022-12-05")));
        } catch (Exception e) {

        }
        return transactionList;
    }


}
