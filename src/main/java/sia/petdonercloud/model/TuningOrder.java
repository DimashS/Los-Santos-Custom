package sia.petdonercloud.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TuningOrder implements Serializable {
    private static final long serialVersionUID = 1;
    private Long id;
    private Date placedAt;

    private String clientName;
    private String carMark;
    private String carModel;
    private String carYearProduce;
    private String clientZipCode;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    private List<Tuning> tunings = new ArrayList<>();

    public void addDoner(Tuning tuningElement) {
        this.tunings.add(tuningElement);
    }
}
