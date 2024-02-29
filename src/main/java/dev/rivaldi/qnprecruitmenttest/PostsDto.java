package dev.rivaldi.qnprecruitmenttest;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
class PostsDto {
    long id;
    String slug;
    String url;
    String title;
    String content;
    String image;
    String thumbnail;
    String status;
    String category;
    String publishedAt;
    String updatedAt;
    long userID;
}
