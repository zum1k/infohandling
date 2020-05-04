package com.epam.training.infohandling.composite.impl;

        import com.epam.training.infohandling.composite.TextComponent;
        import com.epam.training.infohandling.entity.ParserType;

        import java.util.List;

public class PunctuationLeaf implements TextComponent {
    public static final String REGULAR_EXPRESSION = "[.?!;:-\".{3}]";

    @Override
    public ParserType getParserType() {
        return null;
    }

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
