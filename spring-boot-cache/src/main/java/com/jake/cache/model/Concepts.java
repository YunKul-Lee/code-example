package com.jake.cache.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@JacksonXmlRootElement(localName = "concepts")
public class Concepts {

    @JacksonXmlElementWrapper(localName = "conceptType")
    private List<Concept> concepts;
}
