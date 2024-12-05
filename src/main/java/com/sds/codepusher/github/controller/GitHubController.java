package com.sds.codepusher.github.controller;

import com.sds.codepusher.github.service.GitHubService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/github")
public class GitHubController {

    private final GitHubService gitHubService;

    @GetMapping("/github-login-success")
    public ModelAndView githubLoginSuccess(@AuthenticationPrincipal OAuth2User principal, ModelAndView model) {
        Set<String> result = principal.getAttributes().keySet();
        // 사용자 정보를 Thymeleaf 템플릿으로 전달
        log.info(principal.toString());

        model.addObject("name", principal.getAttribute("name"));
        model.addObject("email", principal.getAttribute("email"));
        model.addObject("login", principal.getAttribute("login"));
        model.setViewName("github-login-success");
        return model;
    }
}
