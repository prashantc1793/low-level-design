package org.sample.stackoverflow;

import org.sample.stackoverflow.enums.VoteType;
import org.sample.stackoverflow.model.Answer;
import org.sample.stackoverflow.model.Question;
import org.sample.stackoverflow.model.User;
import org.sample.stackoverflow.service.PostService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();

        User user = new User(1, "Prashant", "test@gmail.com");
        String title = "title-1";
        String body = "ques-body";

        // post a question
        Question question = postService.postQuestion(title, body, user);
        postService.displayMap();

        // post an answer to a question
        String ansBody = "test=body";
        Answer answer = postService.postAnswer(ansBody, question.getId(), user);
        postService.displayMap();

        // comment to answer
        postService.commentOnAnswer(question.getId(), answer.getId(), user, "comment-description");
        postService.displayMap();

        // vote an answer
        postService.voteAnswer(question.getId(), answer.getId(), user, VoteType.UP_VOTE);
        postService.displayMap();
    }
}
