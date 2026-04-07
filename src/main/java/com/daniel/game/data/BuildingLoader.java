package com.daniel.game.data;

import com.daniel.game.core.Building;
import java.util.Map;
import java.util.stream.Collectors;

public class BuildingLoader {
    public Map<String, Building> load() {
        XMLParser parser = new XMLParser();

        BuildingWrapper wrapper = parser.parse("buildings.xml", BuildingWrapper.class);

        return wrapper.getBuildings().stream()
                .collect(Collectors.toMap(Building::getId, b -> b));
    }
}
