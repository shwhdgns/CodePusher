package com.sds.codepusher.github.dao;

import com.sds.codepusher.github.entity.GitHubInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface GitHubJpaRepository extends JpaRepository<GitHubInfo, String> {

    List<GitHubInfo> findAllByUserId(String userId);
}
