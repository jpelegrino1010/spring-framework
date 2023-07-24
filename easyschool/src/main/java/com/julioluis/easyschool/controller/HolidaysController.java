package com.julioluis.easyschool.controller;

import com.julioluis.easyschool.model.Holiday;
import com.julioluis.easyschool.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class HolidaysController {

    @Autowired
    private HolidayRepository holidayRepository;

    @GetMapping("/holidays")
    public String displayHolidays(@RequestParam(required = false) boolean federal,
                                  @RequestParam(required = false) boolean festival,
                                  Model model) {
        model.addAttribute("federal",federal);
        model.addAttribute("festival",festival);

        Iterable<Holiday> holidays = holidayRepository.findAll();
        List<Holiday> holidayList= StreamSupport.stream(holidays.spliterator(),false)
                .collect(Collectors.toList());

        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (holidayList.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "holidays.html";
    }
}
