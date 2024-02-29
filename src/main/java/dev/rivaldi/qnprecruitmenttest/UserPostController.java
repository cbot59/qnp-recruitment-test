package dev.rivaldi.qnprecruitmenttest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user-post")
class UserPostController {

    private final RestTemplate restTemplate;

    @GetMapping("/calculate")
    Long get() {
        var start = Instant.now();
        var usersDto = restTemplate.getForEntity("https://jsonplaceholder.org/users", UsersDto[].class);
        log.info("usersDto = {}", usersDto);

        var postsDtos = restTemplate.getForEntity("https://jsonplaceholder.org/posts", PostsDto[].class);
        log.info("postsDtos = {}", postsDtos);

        return Duration.between(start, Instant.now()).toMillis();
    }
}
