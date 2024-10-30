package com.sds.codepusher.github.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

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
    void connectGitHubTest() throws IOException {
        // GIVEN

        // WHEN
        GitHub returnByGitHubTokenService = gitHubService.connectGitHub(gitHubToken);

        // THEN
        Assertions.assertThat(returnByGitHubTokenService.isAnonymous()).isEqualTo(false);
    }
}