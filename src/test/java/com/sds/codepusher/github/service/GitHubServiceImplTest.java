package com.sds.codepusher.github.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@SpringBootTest
class GitHubServiceImplTest {

    @Autowired
    public GitHubService gitHubService;

    public GitHub gitHub;

    @Value("github.personal.token")
    public String gitHubToken;

    @BeforeEach
    void connectGitHub() throws IOException {
        gitHub = new GitHubBuilder().withOAuthToken(gitHubToken).build();
    }

    @Test
    @DisplayName("GitHub Connect 테스트")
    void connectGitHubTest() throws IOException, NoSuchAlgorithmException {
        // 원본 문자열
        String originalString = "codepusher";

        // 64바이트로 만들기 위해 반복
        StringBuilder paddedString = new StringBuilder();
        while (paddedString.length() < 64) {
            paddedString.append(originalString);
        }

        // 64바이트 길이에 맞춘 후 Base64 인코딩
        byte[] encodedBytes = Base64.getEncoder().encode(paddedString.substring(0, 64).getBytes());
        String encodedString = new String(encodedBytes);

        // 출력: Base64로 인코딩된 64바이트 키
        System.out.println("Base64 64-byte encoded key: " + encodedString);

    }
}