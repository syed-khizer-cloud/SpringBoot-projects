package com.example.SplitBill.service;

import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {
    @Override
    public double calculateSplitBill(int numFriends, double totalBill) {
        return totalBill / numFriends;
    }
}
