package dev.rohitahuja.post;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private static final Logger _log = LoggerFactory.getLogger(PostService.class);
    private final List<Post> posts = new ArrayList<>();

    public PostService(ObjectMapper objectMapper) {
        try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/posts.json")) {
            Posts allPosts = objectMapper.readValue(inputStream, Posts.class);
            _log.info("Reading {} posts from JSON data", allPosts.posts().size());
            posts.addAll(allPosts.posts());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON data", e);
        }
    }

    public List<Post> findAll() {
        return posts;
    }

}
