package com.jake.actuator.custom;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LibraryInfo {

    private String name;
    private String version;

    public LibraryInfo(String name) {
        this.name = name;
    }
}
