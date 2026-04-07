package com.daniel.game.data;

import tools.jackson.dataformat.xml.XmlMapper;

public class XMLParser {

    private final XmlMapper mapper = new XmlMapper();

    public <T> T parse(String pathname, Class<T> clazz) {
        var stream = XMLParser.class
                .getClassLoader()
                .getResourceAsStream(pathname);

        return mapper.readValue(stream, clazz);
    }
}
