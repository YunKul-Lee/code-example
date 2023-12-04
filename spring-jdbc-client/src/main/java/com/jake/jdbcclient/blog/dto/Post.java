package com.jake.jdbcclient.blog.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public record Post(
        String id,
        String title,
        String slug,
        LocalDate date,
        int timeToRead,
        String tags
) {}