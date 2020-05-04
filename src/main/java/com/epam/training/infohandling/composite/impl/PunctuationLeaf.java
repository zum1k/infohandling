package com.epam.training.infohandling.composite.impl;

        import com.epam.training.infohandling.composite.TextComponent;

        import java.util.List;

public class PunctuationLeaf implements TextComponent {
    public static final String REGULAR_EXPRESSION = "[.?!;:-\".{3}]";
    //dopisat
    private char value;
    public PunctuationLeaf(char value) {
        this.value = value;
    }

    public void addComponent(TextComponent component) {
    }

    public List<TextComponent> getComponents() {
        return null;
    }
}
