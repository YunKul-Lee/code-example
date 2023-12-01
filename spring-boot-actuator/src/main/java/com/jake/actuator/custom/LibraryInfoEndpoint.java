package com.jake.actuator.custom;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.util.List;

//@Endpoint(id = "libraryInfo")
@WebEndpoint(id = "libraryInfo")
public class LibraryInfoEndpoint {

    /**
     * Controller 의 GetMapping 과 유사
     * 메소드 파라메터의 경우 쿼리스트링으로 전달
     *
     */
    @ReadOperation
    public List<LibraryInfo> getLibraryInfos(@Nullable String name) throws IOException {
        LibraryInfo libraryInfo = new LibraryInfo();
        libraryInfo.setName("logback");
        libraryInfo.setVersion("1.0.0");

        LibraryInfo libraryInfo2 = new LibraryInfo();
        libraryInfo2.setName("jackson");
        libraryInfo2.setVersion("2.0.0");

        List<LibraryInfo> libraryInfos = List.of(libraryInfo, libraryInfo2);

        if(name != null) {
            libraryInfos = libraryInfos.stream().filter(lib -> lib.getName().equals(name)).toList();
        }

        return libraryInfos;
    }
}
