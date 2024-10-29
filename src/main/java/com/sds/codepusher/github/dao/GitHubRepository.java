package com.sds.codepusher.github.dao;

import com.sds.codepusher.github.domain.GitHub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GitHubRepository extends JpaRepository<GitHub, String> {

}
