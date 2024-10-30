package com.sds.codepusher.github.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Table(name = GitHubInfo.TABLE_NAME)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class GitHubInfo {
    // TODO : 임시 테이블

    public static final String TABLE_NAME = "GITHUB_INFO";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seq;

    @Column(name = "user_id", length = 100, nullable = false, unique = false)
    private String userId;

    @Column(name = "repo_name", length = 100, nullable = false, unique = false)
    private String repositoryName;
}
