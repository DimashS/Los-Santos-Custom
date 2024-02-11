package sia.petdonercloud.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import sia.petdonercloud.model.Component;
import sia.petdonercloud.repository.ComponentRepository;

@org.springframework.stereotype.Component
public class ComponentsByIdConverter implements Converter<String, Component> {
    private ComponentRepository componentRepository;

    @Autowired
    public ComponentsByIdConverter(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    @Override
    public Component convert(String id) {
        return componentRepository.findById(id).orElse(null);
    }
}
