package org.example.post.domain.content;

import org.example.post.domain.content.Content;

public class PostContent extends Content {

    private static final int MIN_POST_LENGHT = 5;
    private static final int MAX_POST_LENGHT = 500;

    public PostContent(String content) {
        super(content);
    }

    @Override
    protected void checkText(String contentText) {
        if (contentText == null || contentText.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (contentText.length() > MAX_POST_LENGHT) {
            throw new IllegalArgumentException();
        }

        if (contentText.length() < MIN_POST_LENGHT) {
            throw new IllegalArgumentException();
        }
    }
}
