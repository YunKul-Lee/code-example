package com.jake.cache.config;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.jake.cache.constants.Constant;
import com.jake.cache.model.Concept;
import com.jake.cache.model.Concepts;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Configuration
@Slf4j
public class XmlConfiguration {

    @PostConstruct
    public void loadXmlData() {
        try {
            File xmlFile = Paths.get(System.getProperty("user.dir"), "spring-boot-cache/src/main/resources/config.xml").toFile();
            XmlMapper xmlMapper = new XmlMapper();

            Concepts concepts = xmlMapper.readValue(xmlFile, Concepts.class);

            for(Concept concept: concepts.getConcepts()) {
                log.info("load data code: " + concept.getCode());
                Constant.CONCEPT_MAP.put(concept.getCode(), concept);
            }

        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
