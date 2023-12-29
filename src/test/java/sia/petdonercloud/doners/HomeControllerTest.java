package sia.petdonercloud.doners;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import sia.petdonercloud.controller.HomeController;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HomeController.class)
public class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/")) // выполнить запрос get
                .andExpect(status().isOk()) // ожидается код ответа 200
                .andExpect(view().name("home")) // ожидается имя представления
                .andExpect(content().string( // ожидается наличие строки Welcome to Brother Kebab
                        containsString("Welcome to Brother Kebab")));
    }
}

