package org.example.user.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserInfoTest {

    @Test
    void createUser() {
        // given
        String name = "abcd";
        String profileImageUrl = "";

        // when
        // then
        assertDoesNotThrow(() -> new UserInfo(name, profileImageUrl));
    }

    @Test
    void createUserError() {
        // given
        String name = "";
        String profileImageUrl = "";

        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> new UserInfo(name, profileImageUrl));
    }
}