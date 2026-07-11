package org.sample.stackoverflow.model;

public class Comment {
    private final int id;
    private final User commentedBy;
    private final Post post;
    private final String description;

    private Comment(Builder builder) {
        this.id = builder.id;
        this.commentedBy = builder.commentedBy;
        this.post = builder.post;
        this.description = builder.description;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", commentedBy=" + commentedBy +
                ", postId=" + (post != null ? post.getId() : null) +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder {
        private int id;
        private User commentedBy;
        private Post post;
        private String description;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder commentedBy(User commentedBy) {
            this.commentedBy = commentedBy;
            return this;
        }

        public Builder post(Post post) {
            this.post = post;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Comment build() {
            if (commentedBy == null) {
                throw new IllegalStateException("commentedBy is required");
            }
            if (post == null) {
                throw new IllegalStateException("post is required");
            }
            if (description == null || description.isBlank()) {
                throw new IllegalStateException("description is required");
            }
            return new Comment(this);
        }
    }
}