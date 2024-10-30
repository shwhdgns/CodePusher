package com.sds.codepusher.github.service;

import com.sds.codepusher.github.dao.GitHubJpaRepository;
import com.sds.codepusher.github.dto.GitHubResponseDTO;
import com.sds.codepusher.github.entity.GitHubInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Slf4j(topic = "github-api")
@Service
@RequiredArgsConstructor
public class GitHubServiceImpl implements GitHubService {

    private final GitHubJpaRepository gitHubJpaRepository;

    @Value("${github.personal.token}")
    private String gitHubPersonalToken;

    public GitHubResponseDTO read(String userId) {
        List<GitHubInfo> gitHubInfoList = gitHubJpaRepository.findAllByUserId(userId);
        return new GitHubResponseDTO(userId, gitHubInfoList);
    }

    @Override
    public GitHub connectGitHub(String token) throws IOException {
        if (token == null) token = gitHubPersonalToken;

        GitHub github = new GitHubBuilder().withOAuthToken(token).build();
        github.checkApiUrlValidity();

        // TODO : Connect한 깃헙 Redis에 put

        return github;
    }
}
