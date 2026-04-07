package com.daniel.game.data;

import com.daniel.game.core.Upgrade;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class UpgradeLoader {
    public LinkedHashMap<String, Upgrade> load() throws IOException {
        XMLParser parser = new XMLParser();

        UpgradeWrapper wrapper = parser.parse("upgrades.xml", UpgradeWrapper.class);

        return wrapper.getUpgrades().stream()
                .collect(Collectors.toMap(
                        Upgrade::getId,
                        u -> u,
                        (existing, replacement) -> existing, // handle duplicate keys
                        LinkedHashMap::new
                ));
    }
}
