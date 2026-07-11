package org.sample.stackoverflow.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Question extends Post{
    private final String title;
    private final String body;
    private final List<Answer> answerList;

    public Question(int id, User postedBy, Map<User, Vote> voteList,
                    LocalDateTime createdAt, String title, String body, List<Answer> answerList) {
        super(id, postedBy, voteList, createdAt);
        this.title = title;
        this.body = body;
        this.answerList = answerList;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    @Override
    public String toString() {
        return "Question{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", answerList=" + answerList +
                '}';
    }


}
