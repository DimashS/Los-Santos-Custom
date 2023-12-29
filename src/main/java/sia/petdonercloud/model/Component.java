package sia.petdonercloud.model;

import lombok.Data;

@Data
public class Component {
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        SPEED_BOOST, APPEARANCE_CHANGE, TINTING, WHEELS_TUNING, SUPPORT_TOOL, PAINTING, INTERIOR
    }
}
