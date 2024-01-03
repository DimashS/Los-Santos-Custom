package sia.petdonercloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sia.petdonercloud.model.Component;
import sia.petdonercloud.model.Component.Type;
import sia.petdonercloud.model.Tuning;
import sia.petdonercloud.model.TuningOrder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tuningOrder")
public class CarTuningCustom {
    @ModelAttribute
    public void addComponentsToModel(Model model) {
        List<Component> components = Arrays.asList(
                new Component("NITR", "NITROUS OXIDE", Component.Type.SPEED_BOOST), // закись азота
                new Component("BMPR", "BUMPER TUNING", Component.Type.APPEARANCE_CHANGE), // покраска бампера
                new Component("HOOD", "HOOD TUNING", Component.Type.APPEARANCE_CHANGE),  // капота покраска
                new Component("TNTG", "WINDOWS LOW LEVEL OF TINTING", Component.Type.TINTING),
                // тонировка низкого уровня
                new Component("TNTG", "WINDOWS HIGH LEVEL OF TINTING", Component.Type.TINTING),
                // тонировка прозрачность меньше
                new Component("RIMS", "RIMS ON WHEELS STEEL", Component.Type.WHEELS_TUNING),
                // диски на колеса стальные
                new Component("RIMS", "RIMS ON WHEELS Cast (light alloy/casting)", Component.Type.WHEELS_TUNING),
                // диски на колеса из лития
                new Component("MFFL", "MUFFLER OF THE CAR", Component.Type.SUPPORT_TOOL),
                // глушитель
                new Component("SPLR", "SPOILER", Component.Type.SUPPORT_TOOL),
                // спойлер
                new Component("ROOF", "ROOF TUNING", Component.Type.APPEARANCE_CHANGE),
                // тюнинг крыши
                new Component("APPR", "PAINTING OF CAR APPEARANCE", Type.PAINTING),
                // раскраска
                new Component("THRS", "THRESHOLDS FOR THE CAR", Type.APPEARANCE_CHANGE),
                // пороги
                new Component("CAR INTERIOR", "INTERIOR COVERS", Type.INTERIOR),
                // салон чехлы
                new Component("CAR INTERIOR", "INTERIOR UPGRADE", Type.INTERIOR)
                // салон
        );
        Type[] types = Component.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(components, type));
        }
    }

    @ModelAttribute(name = "tuningOrder")
    public TuningOrder carTuningOrder() {
        return new TuningOrder();
    }

    @ModelAttribute(name = "tuning")
    public Tuning createTuning() {
        return new Tuning();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        // Предполагается, что 'createTuningModel' автоматически добавит 'tuning' в модель.
        // Если нет, раскомментируйте следующую строку:
        model.addAttribute("tuning", createTuning());
        return "design";
    }

    @PostMapping
    public String processTuning(Tuning tuning,
                              @ModelAttribute TuningOrder tuningOrder) {
        tuningOrder.addTheWholeTuningTemplate(tuning);
        log.info("Processing tuning on car: {}", tuning);
        return "redirect:/client/order";
    }

    private Iterable<Component> filterByType(List<Component> components, Component.Type type) {
        return components.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }
}
