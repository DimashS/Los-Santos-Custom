package sia.petdonercloud.repository;

import sia.petdonercloud.model.Component;

import java.util.Optional;

public interface ComponentRepository {

    Iterable<Component> findAll();

    Optional<Component> findById(String id);

    Component save(Component component);
}
