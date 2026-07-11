package org.sample.stackoverflow.model;

import java.time.LocalDateTime;
import java.util.Map;

public class Post {
    private final int id;
    private final User postedBy;
    Map<User, Vote> userVoteMap;
    private final LocalDateTime createdAt;

    public Post(int id, User postedBy, Map<User, Vote> userVoteMap, LocalDateTime createdAt) {
        this.id = id;
        this.postedBy = postedBy;
        this.userVoteMap = userVoteMap;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public Map<User, Vote> getUserVoteMap() {
        return userVoteMap;
    }

    public void setUserVoteMap(Map<User, Vote> userVoteMap) {
        this.userVoteMap = userVoteMap;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", postedBy=" + postedBy +
                ", userVoteMap=" + userVoteMap +
                ", createdAt=" + createdAt +
                '}';
    }
}
