package com.sds.codepusher.github.service;

import com.sds.codepusher.github.dto.GitHubResponseDTO;
import org.kohsuke.github.GitHub;

import java.io.IOException;

public interface GitHubService {
    GitHubResponseDTO read(String read);

    GitHub connectGitHub(String token) throws IOException;


}
