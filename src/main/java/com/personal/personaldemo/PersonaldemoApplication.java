package com.personal.personaldemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.time.LocalDateTime;

import com.personal.personaldemo.model.Post;
import com.personal.personaldemo.repository.PostRepository;

@SpringBootApplication
@RequiredArgsConstructor
public class PersonaldemoApplication implements CommandLineRunner{

	private final PostRepository postRepository;

	public static void main(String[] args) {
		SpringApplication.run(PersonaldemoApplication.class, args);
	}

	// 초기 데이터를 설정하기위해
	@Override
	public void run(String ... args) throws Exception {
		List<Post> postList = List.of(
            new Post(UUID.randomUUID(), "title1", "content1", "", LocalDateTime.now()),
            new Post(UUID.randomUUID(), "title2", "content2", "", LocalDateTime.now()),
            new Post(UUID.randomUUID(), "title3", "content3", "", LocalDateTime.now())
        );

		postRepository.saveAll(postList);
	}

}
