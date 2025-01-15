package org.example.user.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private final UserInfo userInfo = new UserInfo("test", "");
    private User user1;
    private User user2;

    @BeforeEach
    void init() {
        user1 = new User(1L, userInfo);
        user2 = new User(2L, userInfo);
    }

    @Test
    void equalFalseUser() {
        // when
        boolean isSame = user1.equals(user2);

        // then
        assertFalse(isSame);
    }

    @Test
    void equalTrueUser() {
        // given
        User sameUser = new User(1L, userInfo);

        // when
        boolean isSame = user1.equals(sameUser);

        // then
        assertTrue(isSame);
    }

    @Test
    void hashCodeFalse() {
        // when
        int hashcode1 = user1.hashCode();
        int hashcode2 = user2.hashCode();

        // then
        assertNotEquals(hashcode1, hashcode2);
    }

    @Test
    void hashCodeTrue() {
        // given
        User sameUser = new User(1L, userInfo);

        // when
        int hashcode1 = user1.hashCode();
        int sameUserHashCdoe = sameUser.hashCode();

        // then
        assertEquals(hashcode1, sameUserHashCdoe);
    }

    @Test
    void followCountIncrease() {
        // when
        user1.follow(user2);

        // then
        assertEquals(1, user1.getFollowingCount());
        assertEquals(0, user1.getFollowerCount());
        assertEquals(0, user2.getFollowingCount());
        assertEquals(1, user2.getFollowerCount());
    }

    @Test
    void unfollowCountDecrease() {
        // given
        user1.follow(user2);

        // when
        user1.unfollow(user2);

        // then
        assertEquals(0, user1.getFollowingCount());
        assertEquals(0, user1.getFollowerCount());
        assertEquals(0, user2.getFollowingCount());
        assertEquals(0, user2.getFollowerCount());
    }

    @Test
    void unfollowCountNotDecrease() {
        // when
        user1.unfollow(user2);

        // then
        assertEquals(0, user1.getFollowingCount());
        assertEquals(0, user1.getFollowerCount());
        assertEquals(0, user2.getFollowingCount());
        assertEquals(0, user2.getFollowerCount());
    }
}