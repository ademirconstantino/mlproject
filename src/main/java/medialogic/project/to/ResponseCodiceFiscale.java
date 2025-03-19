package medialogic.project.to;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class ResponseCodiceFiscale {

    private LocalDate dataNascita;
    private Integer eta;

}
