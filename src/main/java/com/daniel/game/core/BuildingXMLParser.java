package com.daniel.game.core;

import tools.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class BuildingXMLParser {
    public static Map<String, Building> parse(String pathname) {
        XmlMapper mapper = new XmlMapper();

        BuildingWrapper wrapper = mapper.readValue(
                new File(getResourcePath(pathname)),
                BuildingWrapper.class
        );

        return wrapper.getBuildings().stream()
                .collect(Collectors.toMap(Building::getId, b -> b));
    }

    private static String getResourcePath(String filename) {
        return Objects.requireNonNull(BuildingXMLParser.class
                .getClassLoader()
                .getResource(filename)
        ).getPath();
    }
}
