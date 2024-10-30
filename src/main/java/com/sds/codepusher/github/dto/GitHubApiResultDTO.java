package com.sds.codepusher.github.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class GitHubApiResultDTO<T> {
    // TODO : API 콜 통합 DTO 개발예정.
    private boolean success;
    private String message;
    private T data;

    public static <T> GitHubApiResultDTO<T> success(T data) {
        return new GitHubApiResultDTO<>(true, "요청 성공", data);
    }

    public static <T> GitHubApiResultDTO<T> error(String message) {
        return new GitHubApiResultDTO<>(false, message, null);
    }

}
