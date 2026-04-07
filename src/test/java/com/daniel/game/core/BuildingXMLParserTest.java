package com.daniel.game.core;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class BuildingXMLParserTest {

    @Test
    public void parse() throws IOException {
        BuildingLoader loader = new BuildingLoader();
        Map<String, Building> buildingMapToTest = loader.load();

        Building matterCondenserX1 = new Building("its u", 10, 1, 0, 0.15);
        Building matterCondenserX10 = new Building("wallsocket", 100, 3, 0, 0.2);

        Map<String, Building> buildingMapTruth = new HashMap<>(Map.of(
                matterCondenserX10.getId(), matterCondenserX10,
                matterCondenserX1.getId(), matterCondenserX1
        ));

        assertEquals(
                buildingMapToTest.get("its u").toString(),
                buildingMapTruth.get("its u").toString()
        );
        assertEquals(
                buildingMapToTest.get("wallsocket").toString(),
                buildingMapTruth.get("wallsocket").toString()
        );
    }
}

