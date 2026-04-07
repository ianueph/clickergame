package com.daniel.game.data;

import com.daniel.game.core.Upgrade;
import tools.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class UpgradeWrapper {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "upgrade")
    private List<Upgrade> upgrades;

    public List<Upgrade> getUpgrades() {
        return upgrades;
    }
}
