package com.sds.codepusher.github.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Table(name = UserInfo.TABLE_NAME)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserInfo {
    // TODO : 임시 테이블
    public static final String TABLE_NAME = "USER_INFO";

    @Id
    @Column(name = "user_id", length = 100, nullable = false, unique = true)
    private String userId;

    @Column(name = "name", length = 100, nullable = false, unique = false)
    private String userName;
}
