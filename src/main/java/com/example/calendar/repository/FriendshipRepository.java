package com.example.calendar.repository;

import com.example.calendar.entities.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {
}