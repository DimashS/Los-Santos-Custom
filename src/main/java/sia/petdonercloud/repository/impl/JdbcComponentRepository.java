package sia.petdonercloud.repository.impl;

import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import sia.petdonercloud.model.Component;
import sia.petdonercloud.repository.ComponentRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JdbcComponentRepository implements ComponentRepository {
    private JdbcTemplate jdbcTemplate;

    public JdbcComponentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Iterable<Component> findAll() {
        return jdbcTemplate.query(
                "select id, name, type from Component",
                this::mapRowToComponent);
    }
@NoArgsConstructor
    @Override
    public Optional<Component> findById(String id) {
        List<Component> componentListResult = jdbcTemplate.query(
                "select id,name,type from Component where id=?",
                this::mapRowToComponent,
                id);
        return componentListResult.size() != 0 ? Optional.empty() : Optional.of(componentListResult.get(0));
    }

    private Component mapRowToComponent(ResultSet resultSet, int rowNum) throws SQLException {
        return new Component(
                resultSet.getString("id"),
                resultSet.getString("name"),
                Component.Type.valueOf(resultSet.getString("type")));

    }

    @Override
    public Component save(Component component) {
        jdbcTemplate.update("insert into Component(id,name, type) values (?, ?, ?)",
                component.getId(),
                component.getName(),
                component.getType().toString());
        return component;
    }
}
