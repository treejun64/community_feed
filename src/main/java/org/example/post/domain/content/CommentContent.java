package org.example.post.domain.content;

public class CommentContent extends Content {

    private static final int MAX_COMMENT_LENGTH = 100;

    public CommentContent(String contentText) {
        super(contentText);
    }

    @Override
    protected void checkText(String contentText) {
        if (contentText == null || contentText.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (contentText.length() > MAX_COMMENT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
