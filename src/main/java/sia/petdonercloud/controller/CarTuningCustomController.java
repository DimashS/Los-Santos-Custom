package sia.petdonercloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import sia.petdonercloud.model.Component;
import sia.petdonercloud.repository.ComponentRepository;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tuningOrder")
public class CarTuningCustomController {

    private final ComponentRepository componentRepository;

    @Autowired
    public CarTuningCustomController(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    @ModelAttribute
    public void addComponentToCarModel(Model model) {
        Iterable<Component> components = componentRepository.findAll();
        Component.Type[] types = Component.Type.values();
        for (Component.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType((List<Component>) components, type));
        }
    }

    private Iterable<Component> filterByType(
            List<Component> components, Component.Type type) {
        return components
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }


}
