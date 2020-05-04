package com.epam.training.infohandling.composite;

import com.epam.training.infohandling.entity.ParserType;

import java.util.List;

public interface TextComponent {
    void addComponent(TextComponent component);
    List<TextComponent> getComponents();
    ParserType getParserType();
  }
