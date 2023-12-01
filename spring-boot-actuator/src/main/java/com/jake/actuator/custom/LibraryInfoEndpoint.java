package com.jake.actuator.custom;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

import java.util.List;

@Endpoint(id = "libraryInfo")
public class LibraryInfoEndpoint {

    @ReadOperation
    public List<LibraryInfo> getLibraryInfos() {

        LibraryInfo libraryInfo = new LibraryInfo();
        libraryInfo.setName("logback");
        libraryInfo.setVersion("1.0.0");

        LibraryInfo libraryInfo2 = new LibraryInfo();
        libraryInfo2.setName("jackson");
        libraryInfo2.setVersion("2.0.0");

        return List.of(libraryInfo, libraryInfo2);
    }
}
