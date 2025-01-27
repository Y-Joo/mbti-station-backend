package com.tamsadan.mbti.config;

import com.tamsadan.mbti.repository.CommentRepository;
import com.tamsadan.mbti.repository.UserRepository;
import com.tamsadan.mbti.repository.PostRepository;
import com.tamsadan.mbti.repository.VotingPostRepository;
import com.tamsadan.mbti.service.CommentService;
import com.tamsadan.mbti.service.UserService;
import com.tamsadan.mbti.service.PostService;
import com.tamsadan.mbti.service.VotingPostService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final VotingPostRepository votingPostRepository;
    private final CommentRepository commentRepository;

    public SpringConfig(UserRepository userRepository, PostRepository postRepository, VotingPostRepository votingPostRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.votingPostRepository = votingPostRepository;
        this.commentRepository = commentRepository;
    }

    @Bean
    public UserService userService(){
        return new UserService(userRepository);
    }
    @Bean
    public PostService postService(){
        return new PostService(postRepository);
    }
    @Bean
    public VotingPostService votingPostService(){
        return new VotingPostService(votingPostRepository);
    }
    @Bean
    public CommentService commentService(){
        return new CommentService(commentRepository);
    }
}
