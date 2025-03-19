package medialogic.project.library;

import java.time.LocalDate;
import java.time.Period;

public class Utility {

    public static Integer cacolaEta(String codiceFiscale) {
        LocalDate dataNascita = calcolaDataDiNascita(codiceFiscale);
        LocalDate now = LocalDate.now();
        Period period = Period.between(dataNascita, now);
        return period.getYears();
    }

    public static LocalDate calcolaDataDiNascita(String codiceFiscale) {
        if (codiceFiscale == null || codiceFiscale.length() != 16) {
            throw new IllegalArgumentException("Codice fiscale non valido");
        }
        String anno = codiceFiscale.substring(6, 8);
        String mese = codiceFiscale.substring(8, 9);
        String giorno = codiceFiscale.substring(9, 11);

        int annoInt = Integer.parseInt(anno);
        int giornoInt = Integer.parseInt(giorno);

        // Determina il secolo
        if (annoInt < 100) {
            annoInt += (annoInt < 30) ? 2000 : 1900;
        }

        // Determina il mese
        String[] mesi = {"A", "B", "C", "D", "E", "H", "L", "M", "P", "R", "S", "T"};
        int meseInt = -1;
        for (int i = 0; i < mesi.length; i++) {
            if (mesi[i].equals(mese)) {
                meseInt = i + 1;
                break;
            }
        }

        // Se il giorno è maggiore di 31, significa che è una donna (aggiungere 40)
        if (giornoInt > 31) {
            giornoInt -= 40;
        }

        // Crea la data di nascita
        LocalDate dataNascita = LocalDate.of(annoInt, meseInt, giornoInt);
        return dataNascita;
    }

}
