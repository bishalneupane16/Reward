package com.shop.service.impl;

import com.shop.model.Transaction;
import com.shop.pojo.CustomerRewardPojo;
import com.shop.service.RewardService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RewardServiceImpl implements RewardService {


    @Override
    public List<CustomerRewardPojo> getRewardPoints() {
        List<Transaction> transactions = getSampleDataSet();
        Map<String, List<Transaction>> transactionGroupByCustomerId = transactions.stream().collect(Collectors.groupingBy(Transaction::getCustomerId));
        List<CustomerRewardPojo> collect = transactionGroupByCustomerId.entrySet().stream().map(item -> {
            CustomerRewardPojo customerRewardPojo = new CustomerRewardPojo();
            customerRewardPojo.setCustomerId(item.getKey());
            customerRewardPojo.setRewards(calculateRewardPoints(item.getValue()));
            return customerRewardPojo;
        }).collect(Collectors.toList());
        return collect;
    }

    private List<String> months = Arrays.asList("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC");

    public Map<String, Integer> calculateRewardPoints(List<Transaction> value) {
        Map<String, Integer> monthlyRewardPoint = new HashMap<>();
        final Integer[] total = {0};
        value.stream().forEach(item -> {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(item.getDate());
            int i = calendar.get(Calendar.MONTH);
            String month = months.get(i);
            Integer rewardPoint = calculate(item.getAmount());
            total[0] += rewardPoint;
            if(monthlyRewardPoint.get(month) != null)
                monthlyRewardPoint.put(month, monthlyRewardPoint.get(month) + rewardPoint);
            else
                monthlyRewardPoint.put(month, rewardPoint);
        });

        monthlyRewardPoint.put("Total", total[0]);
        return monthlyRewardPoint;
    }

    private Integer calculate(Double amount) {
        if(amount <= 50)
            return 0;
        else if(amount <= 100)
            return amount.intValue() - 50;
        else
            return 50 + (amount.intValue() - 100) * 2;

    }

    public List<Transaction> getSampleDataSet() {
        List<Transaction> transactionList = new ArrayList<>();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            transactionList.add(new Transaction("1", 70D, dateFormat.parse("2022-10-05")));
            transactionList.add(new Transaction("1", 110D, dateFormat.parse("2022-10-05")));
            transactionList.add(new Transaction("1", 20D, dateFormat.parse("2022-11-05")));
            transactionList.add(new Transaction("1", 500D, dateFormat.parse("2022-12-05")));
            transactionList.add(new Transaction("1", 85D, dateFormat.parse("2022-12-05")));
            transactionList.add(new Transaction("2", 60D, dateFormat.parse("2022-12-05")));
            transactionList.add(new Transaction("2", 70D, dateFormat.parse("2022-10-05")));
            transactionList.add(new Transaction("2", 70D, dateFormat.parse("2022-11-05")));
            transactionList.add(new Transaction("3", 100D, dateFormat.parse("2022-12-05")));
            transactionList.add(new Transaction("3", 170D, dateFormat.parse("2022-11-05")));
            transactionList.add(new Transaction("3", 10D, dateFormat.parse("2022-10-05")));
            transactionList.add(new Transaction("3", 200D, dateFormat.parse("2022-12-05")));
            transactionList.add(new Transaction("4", 70D, dateFormat.parse("2022-11-05")));
            transactionList.add(new Transaction("4", 70D, dateFormat.parse("2022-12-05")));
        } catch (Exception e) {

        }
        return transactionList;
    }
}
