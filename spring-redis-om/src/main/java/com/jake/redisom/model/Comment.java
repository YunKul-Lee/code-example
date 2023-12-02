package com.jake.redisom.model;

import com.redis.om.spring.annotations.Searchable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Searchable(nostem = true)
    private String content;
}
