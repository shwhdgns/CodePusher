package com.sds.codepusher.github.controller;

import com.sds.codepusher.github.dto.GitHubResponseDTO;
import com.sds.codepusher.github.service.GitHubService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.kohsuke.github.GitHub;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/github")
public class GitHubController {

    private final GitHubService gitHubService;

    @GetMapping("/test/{githubId}")
    public ResponseEntity getGitHubRepository(@PathVariable("githubId") String gitHubId, HttpServletRequest request) {
        GitHubResponseDTO response = gitHubService.read(gitHubId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/connect")
    public GitHub connectGitHub(HttpServletRequest request) throws IOException {
        return gitHubService.connectGitHub("");
    }

}
