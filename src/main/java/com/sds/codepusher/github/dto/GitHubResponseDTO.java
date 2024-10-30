package com.sds.codepusher.github.dto;

import com.sds.codepusher.github.entity.GitHubInfo;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GitHubResponseDTO {
    private String userId;
    private List<GitHubInfo> gitHubInfoList;
}
