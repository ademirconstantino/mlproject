package medialogic.project.service;

import medialogic.project.to.ResponseCodiceFiscale;
import org.springframework.stereotype.Service;

import static medialogic.project.library.Utility.cacolaEta;
import static medialogic.project.library.Utility.calcolaDataDiNascita;

@Service
public class CodiceFiscaleService {
    
    public ResponseCodiceFiscale getCodiceFiscale(String codiceFiscale) {
        return ResponseCodiceFiscale.builder().
                dataNascita(calcolaDataDiNascita(codiceFiscale)).
                eta(cacolaEta(codiceFiscale)).build();
    }

}