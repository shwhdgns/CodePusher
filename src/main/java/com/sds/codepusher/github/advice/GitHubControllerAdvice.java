package com.sds.codepusher.github.advice;

import com.sds.codepusher.github.dto.GitHubApiResultDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice(basePackages = "com.sds.codepusher.github")
public class GitHubControllerAdvice {
    // TODO : Exception Handler 개발예정
    @ExceptionHandler
    public GitHubApiResultDTO<String> handleIOException(IOException exception) {
        return new GitHubApiResultDTO<>(false, "", exception.getMessage());
    }

}
