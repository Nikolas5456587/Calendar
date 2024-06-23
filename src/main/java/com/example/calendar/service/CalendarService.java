package com.example.calendar.service;

import com.example.calendar.entities.Friendship;
import com.example.calendar.entities.Member;
import com.example.calendar.repository.FriendshipRepository;
import com.example.calendar.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private FriendshipRepository friendshipRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public List<Friendship> getAllPlans() {
        return friendshipRepository.findAll();
    }

    public void addPlan(Friendship friendship) {
        friendshipRepository.save(friendship);
    }
}