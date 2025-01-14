package org.example.user.domain;

import org.example.common.domain.PositiveIntegerCounter;

import java.util.Objects;

public class User {

    private final Long id;
    private final UserInfo info;
    private final PositiveIntegerCounter followingCount;
    private final PositiveIntegerCounter followerCount;

    public User(Long id, UserInfo userInfo) {
        if (userInfo == null) {
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.info = userInfo;
        this.followingCount = new PositiveIntegerCounter();
        this.followerCount = new PositiveIntegerCounter();
    }

    public void follow(User targetUser) {
        if (this.equals(targetUser)) {
            throw new IllegalArgumentException();
        }
        followingCount.increse();
        // targetUser.followerCount.increse(); // 캡슐화 위반 (본인의 객체에만 관여하도록 수정)
        targetUser.increaseFollwerCount();
    }

    public void unfollow(User targetUser) {
        if (this.equals(targetUser)) {
            throw new IllegalArgumentException();
        }
        followingCount.decrease();
        // targetUser.followerCount.decrease();
        targetUser.decreaseFollowerCount();
    }

    private void increaseFollwerCount() {
        followerCount.increse();
    }

    private void decreaseFollowerCount() {
        followerCount.decrease();
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
