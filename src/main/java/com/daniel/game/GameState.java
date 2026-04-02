package com.daniel.game;

import java.util.ArrayList;
import java.util.List;

public class GameState {

    private int currency;
    private final List<Renderable> renderables = new ArrayList<>();

    public GameState(int currency) {
        this.currency = currency;
        setupUI();
    }

    private void setupUI() {
        renderables.add(new IncrementButton(5, 5, "Increment", this));
        renderables.add(new CurrencyTextField(5, 3, this));
    }

    public List<Renderable> getRenderables() {
        return this.renderables;
    }

    public void increment() {
        this.currency += 1;
    }

    public int getCurrency() {
        return this.currency;
    }
}
