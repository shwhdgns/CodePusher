package com.sds.codepusher.github.advice;

import com.sds.codepusher.github.dto.GitHubApiResultDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice(basePackages = "com.sds.codepusher.github")
public class GitHubControllerAdvice {
    // TODO : Exception Handler 개발예정
    @ExceptionHandler
    public GitHubApiResultDTO<String> handleIOException(IOException exception) {
        return new GitHubApiResultDTO<>(false, "", exception.getMessage());
    }
}
