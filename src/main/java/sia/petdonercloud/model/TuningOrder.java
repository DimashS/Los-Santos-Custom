package sia.petdonercloud.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TuningOrder {
    private String clientName;
    private String carMark;
    private String carModel;
    private String carYearProduce;
    private String clientZipCode;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    private List<Tuning> tunings = new ArrayList<>();

    public void addTheWholeTuningTemplate(Tuning tuning) {
        this.tunings.add(tuning);
    }
}
