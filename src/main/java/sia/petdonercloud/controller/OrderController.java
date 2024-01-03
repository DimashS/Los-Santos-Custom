package sia.petdonercloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import sia.petdonercloud.model.TuningOrder;

@Slf4j
@Controller
@RequestMapping("/client")
@SessionAttributes("tuningOrder")
public class OrderController {

    @GetMapping("/order")
    public String orderForm() {
        return "order";
    }

    @PostMapping
    public String processOrder(TuningOrder order,
                               SessionStatus sessionStatus) {
        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}