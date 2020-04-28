package com.epam.training.infohandling.repository.impl;

import com.epam.training.infohandling.composite.TextComponent;
import com.epam.training.infohandling.composite.impl.TextComposite;
import com.epam.training.infohandling.repository.Repository;
import com.epam.training.infohandling.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextRepository implements Repository<TextComponent> {
    private static final TextRepository INSTANCE = new TextRepository();
    private static final Logger LOGGER = LogManager.getLogger(TextRepository.class);

    private List<TextComponent> components = new ArrayList<>();

    private TextRepository() {
    }
    public static TextRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public void add(TextComponent composite) {
        components.add(composite);
        LOGGER.info("Component added: " + composite);
    }

    @Override
    public void remove(TextComponent composite) {
        LOGGER.info("Composite removed: "+composite);
    }

    @Override
    public void update(TextComponent composite) {
        LOGGER.info("Composite updated: "+composite);
    }

    @Override
    public List<TextComponent> sort(Comparator<TextComponent> comparator) {
        components.sort(comparator);
        LOGGER.info("Components sorted by"+comparator.getClass());
        return components;
    }

    @Override
    public List<TextComponent> getAll() {
        LOGGER.info("Component returned.");
        return components;
    }

    @Override
    public List<TextComponent> query(Specification<TextComponent> specification) {
        List<TextComponent> result = new ArrayList<>();
        for (TextComponent component : components) {
            if (specification.isSpecified(component)) {
                result.add(component);
            }
        }
        LOGGER.info("Components quered by:" + specification.getClass());
        return result;
    }
}
