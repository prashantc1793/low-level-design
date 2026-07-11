package org.sample.stackoverflow.service;

import org.sample.stackoverflow.enums.VoteType;
import org.sample.stackoverflow.model.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class PostService {
    Map<Integer, Question> questionMap = new HashMap<>();

    private final AtomicInteger idGenerator = new AtomicInteger(1);
    private final AtomicInteger ansGenerator = new AtomicInteger(1);
    private final AtomicInteger commentIdGenerator = new AtomicInteger(1);

    // display questionMap
    public void displayMap() {
        System.out.println("Map size = " + questionMap.size());
        System.out.println(questionMap);
    }

    // post a question
    public Question postQuestion(String title, String body, User postedBy) {
        if(Objects.isNull(body)) {
            throw new IllegalArgumentException("Question cannot be posted...");
        }
        Question ques = new Question(idGenerator.getAndIncrement(), postedBy,
                 null, LocalDateTime.now(), title, body, new ArrayList<>());

        questionMap.put(ques.getId(), ques);
        return ques;
    }

    // answer to a question
    public Answer postAnswer(String body, int questionId, User postedBy) {
        if(!questionMap.containsKey(questionId)) throw new IllegalArgumentException("Question doesn't exist in the system");

        Question question = questionMap.get(questionId);
        Answer answer = new Answer.Builder()
                .id(ansGenerator.getAndIncrement())
                .postedBy(postedBy)
                .body(body)
                .build();
        question.getAnswerList().add(answer);
        return answer;
    }

    // comment on answer
    public Comment commentOnAnswer(int questionId, int answerId, User commentedBy, String description) {
        if(!questionMap.containsKey(questionId)) throw new IllegalArgumentException("Question doesn't exist in the system");

        Answer targetAnswer = null;
        Question question = questionMap.get(questionId);
        for(Answer answer : question.getAnswerList()) {
            if(answerId == answer.getId()) {
                targetAnswer = answer;
                break;
            }
        }
        if (targetAnswer == null) {
            throw new IllegalArgumentException("Answer doesn't exist in this question");
        }

        Comment comment = new Comment.Builder()
                .id(commentIdGenerator.getAndIncrement())
                .commentedBy(commentedBy)
                .post(targetAnswer)
                .description(description)
                .build();
        targetAnswer.getCommentList().add(comment);
        return comment;
    }

    // vote for answer
    public void voteAnswer(int questionId, int answerId, User user, VoteType voteType) {
        Question question = questionMap.get(questionId);
        if (question == null) {
            throw new IllegalArgumentException("Question doesn't exist in the system");
        }

        Answer targetAnswer = null;
        for (Answer answer : question.getAnswerList()) {
            if (answer.getId() == answerId) {
                targetAnswer = answer;
                break;
            }
        }
        if (targetAnswer == null) {
            throw new IllegalArgumentException("Answer doesn't exist in this question");
        }

        Map<User, Vote> userVoteMap = targetAnswer.getUserVoteMap();
        if (userVoteMap == null) {
            userVoteMap = new HashMap<>();
            targetAnswer.setUserVoteMap(userVoteMap);
        }
        userVoteMap.put(user, new Vote(voteType));
    }

    // search for question
    public Question search(int questionId) {
        if(!questionMap.containsKey(questionId)) throw new IllegalArgumentException("Question doesn't exist in the system");
        return questionMap.get(questionId);
    }
}
