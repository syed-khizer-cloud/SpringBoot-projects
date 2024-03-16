package com.example.SplitBill.controller;

import com.example.SplitBill.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BillController {

    @PostMapping("/calculate")
    public String calculateBill(@RequestParam("numFriends") int numFriends,
                                @RequestParam("friendNames") List<String> friendNames,
                                @RequestParam("friendPayments") List<Double> friendPayments,
                                Model model) {
        // Calculate total payment made by all friends
        double totalPaid = friendPayments.stream().mapToDouble(Double::doubleValue).sum();

        // Calculate split amount
        double splitAmount = totalPaid / numFriends;

        // Subtract each friend's payment from split amount to get what each friend owes
        List<Double> amountsOwed = friendPayments.stream().map(payment -> splitAmount - payment).collect(Collectors.toList());

        model.addAttribute("splitAmount", splitAmount);
        model.addAttribute("friendNames", friendNames);
        model.addAttribute("amountsOwed", amountsOwed);

        return "result";
    }
}