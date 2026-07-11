package org.sample.stackoverflow.model;

import org.sample.stackoverflow.enums.VoteType;

public class Vote {
    private final VoteType voteType;

    public Vote(VoteType voteType) {
        this.voteType = voteType;
    }

    @Override
    public String toString() {
        return "Vote{" +
                ", voteType=" + voteType +
                '}';
    }
}
