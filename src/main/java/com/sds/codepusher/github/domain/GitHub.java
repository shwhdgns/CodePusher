package com.sds.codepusher.github.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class GitHub {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
