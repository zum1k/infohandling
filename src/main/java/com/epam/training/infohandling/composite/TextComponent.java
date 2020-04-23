package com.epam.training.infohandling.composite;

import java.util.List;

public interface TextComponent {
    void addComponent(TextComponent component);
    List<TextComponent> getComponents();
  }
