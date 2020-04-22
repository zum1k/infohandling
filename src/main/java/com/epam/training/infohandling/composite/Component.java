package com.epam.training.infohandling.composite;

import java.util.List;

public interface Component {
    void addComponent(Component component);
    List<Component> getComponents();
  }
