package com.gm.game.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    UserQuestionService userService;

    @Test
    void addNewQuestionForNewUser() {
        userService.addNewQuestion("user1", "q1");
        userService.addNewQuestion("user1", "q2");
        userService.addNewQuestion("user2", "q2");
        userService.addNewQuestion("user1", "q2");
        userService.addNewQuestion("user2", "q3");
        Set userQuestions1 = userService.getQuestions("user1");
        Set userQuestions2 = userService.getQuestions("user2");
        assertEquals(userQuestions1.size(), 2);
        assertEquals(userQuestions2.size(), 2);
    }
}