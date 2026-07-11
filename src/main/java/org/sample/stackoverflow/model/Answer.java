package org.sample.stackoverflow.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Answer extends Post {
    private final String body;
    private final List<Comment> commentList;

    private Answer(Builder builder) {
        super(builder.id, builder.postedBy, builder.userVoteMap, builder.createdAt);
        this.body = builder.body;
        this.commentList = builder.commentList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "body='" + body + '\'' +
                ", commentList=" + commentList +
                ", userVoteMap=" + getUserVoteMap() +
                '}';
    }

    public static class Builder {
        private int id;
        private User postedBy;
        private final Map<User, Vote> userVoteMap = new HashMap<>();
        private final LocalDateTime createdAt = LocalDateTime.now();
        private String body;
        private final List<Comment> commentList = new ArrayList<>();

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder postedBy(User postedBy) {
            this.postedBy = postedBy;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Answer build() {
            if (postedBy == null) {
                throw new IllegalStateException("postedBy is required");
            }
            if (body == null || body.isBlank()) {
                throw new IllegalStateException("body is required");
            }
            return new Answer(this);
        }
    }
}