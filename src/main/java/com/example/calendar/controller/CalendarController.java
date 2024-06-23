package com.example.calendar.controller;


import com.example.calendar.entities.Friendship;
import com.example.calendar.entities.Member;
import com.example.calendar.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class CalendarController {
    @Autowired
    private CalendarService calendarService;

    @GetMapping("/")
    public String viewCalendar(Model model) {
        List<Member> members = calendarService.getAllMembers();
        List<Friendship> plans = calendarService.getAllPlans();
        model.addAttribute("members", members);
        model.addAttribute("plans", plans);
        return "calendar";
    }

    @PostMapping("/addPlan")
    public String addPlan(@RequestParam Long memberId, @RequestParam String plan, @RequestParam String dateTime) {
        Member member = calendarService.getAllMembers().stream()
                .filter(m -> m.getId().equals(memberId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID"));

        Friendship friendship = new Friendship();
        friendship.setMember(member);
        friendship.setPlan(plan);
        friendship.setDateTime(LocalDateTime.parse(dateTime));
        calendarService.addPlan(friendship);
        return "redirect:/";
    }
}