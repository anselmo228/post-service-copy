package com.justdo.plug.post.domain.hashtag;

import com.justdo.plug.post.domain.hashtag.repository.HashtagRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitialDataLoader implements CommandLineRunner {

    private final HashtagRepository hashtagRepository;

    public InitialDataLoader(HashtagRepository hashtagRepository) {
        this.hashtagRepository = hashtagRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Hashtag hashtag1 = new Hashtag();
        hashtag1.setName("일상");
        hashtagRepository.save(hashtag1);

        Hashtag hashtag2 = new Hashtag();
        hashtag2.setName("스포츠");
        hashtagRepository.save(hashtag2);
    }
}

