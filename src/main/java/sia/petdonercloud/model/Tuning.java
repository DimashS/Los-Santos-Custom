package sia.petdonercloud.model;

import lombok.Data;

import java.util.List;

@Data
public class Tuning {
    private String name;
    private List<Component> components;
}
