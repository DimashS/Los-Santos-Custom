package sia.petdonercloud.utils;

import org.springframework.core.convert.converter.Converter;
import sia.petdonercloud.model.Component;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Component
public class ComponentByIdConverter implements Converter<String, Component> {
    private Map<String, Component> componentMap = new HashMap<>();

    public ComponentByIdConverter() {
        componentMap.put("NITR", new Component("NITR", "NITROUS OXIDE", Component.Type.SPEED_BOOST));
        componentMap.put("BMPR", new Component("BMPR", "BUMPER TUNING", Component.Type.APPEARANCE_CHANGE));
        componentMap.put("HOOD", new Component("HOOD", "HOOD TUNING", Component.Type.APPEARANCE_CHANGE));
        componentMap.put("TNTG", new Component("TNTG", "WINDOWS LOW LEVEL OF TINTING", Component.Type.TINTING));
        componentMap.put("TNTG", new Component("TNTG", "WINDOWS HIGH LEVEL OF TINTING", Component.Type.TINTING));
        componentMap.put("RIMS", new Component("RIMS", "RIMS ON WHEELS STEEL", Component.Type.WHEELS_TUNING));
        componentMap.put("MFFL", new Component("RIMS", "MUFFLER OF THE CAR", Component.Type.SUPPORT_TOOL));
        componentMap.put("SPLR", new Component("MFFL", "SPOILER", Component.Type.SUPPORT_TOOL));
        componentMap.put("ROOF", new Component("ROOF", "ROOF TUNING", Component.Type.APPEARANCE_CHANGE));
        componentMap.put("APPR", new Component("APPR", "PAINTING OF CAR APPEARANCE", Component.Type.PAINTING));
        componentMap.put("THRS", new Component("THRS", "THRESHOLDS FOR THE CAR", Component.Type.APPEARANCE_CHANGE));
        componentMap.put("CAR INTERIOR", new Component("CAR INTERIOR", "INTERIOR COVERS", Component.Type.INTERIOR));
        componentMap.put("CAR INTERIOR", new Component("CAR INTERIOR", "INTERIOR UPGRADE", Component.Type.INTERIOR));
    }

    @Override
    public Component convert(String id) {
        return componentMap.get(id);
    }
}
