package com.daniel.game.core;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.Assert.*;

public class BuildingXMLParserTest {

    @Test
    public void parse() {
        Map<String, Building> buildingMapToTest = BuildingXMLParser.parse("buildings.xml");

        GameState testState = new GameState(50);
        Building matterCondenserX1 = testState.instantiateBuilding("its u",10, 1, 0.15);
        Building matterCondenserX10 = testState.instantiateBuilding("wallsocket",100, 3, 0.20);
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

