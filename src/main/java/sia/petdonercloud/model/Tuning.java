package sia.petdonercloud.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Tuning {
    private Long id;
    private String name;
    private List<Component> components;
    private Date createdAt = new Date();
}
