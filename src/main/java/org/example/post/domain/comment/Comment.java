package org.example.post.domain.comment;

import org.example.common.domain.PositiveIntegerCounter;
import org.example.post.domain.Post;
import org.example.post.domain.content.Content;
import org.example.user.domain.User;

public class Comment {

    private final Long id;
    private final User author;
    private final Post post;
    private final Content content;
    private final PositiveIntegerCounter likeCount;

    public Comment(Long id, User author, Post post, Content content) {
        if (author == null) {
            throw new IllegalArgumentException();
        }

        if (post == null) {
            throw new IllegalArgumentException();
        }

        if (content == null) {
            throw new IllegalArgumentException();
        }


        this.id = id;
        this.author = author;
        this.post = post;
        this.content = content;
        this.likeCount = new PositiveIntegerCounter();
    }

    public void like(User user) {
        if (this.author.equals(user)) {
            throw new IllegalArgumentException();
        }

        likeCount.increse();
    }

    public void unlike() {
        likeCount.decrease();
    }

    public void updateComment(User author, String updateContent) {
        if (!this.author.equals(author)) {
            throw new IllegalArgumentException();
        }

        this.content.updateContent(updateContent);
    }
}
