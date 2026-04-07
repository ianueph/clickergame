package com.daniel.game.data;

import com.daniel.game.core.Building;
import tools.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class BuildingWrapper {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "building")
    private List<Building> buildings;

    public List<Building> getBuildings() {
        return buildings;
    }
}
