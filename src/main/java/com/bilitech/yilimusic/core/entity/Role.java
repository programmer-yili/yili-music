package com.bilitech.yilimusic.core.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Role extends BaseEntity {
    private String name;

    private String title;
}
