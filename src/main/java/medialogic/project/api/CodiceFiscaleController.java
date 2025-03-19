package medialogic.project.api;

import medialogic.project.service.CodiceFiscaleService;
import medialogic.project.to.CodiceFiscale;
import medialogic.project.to.ResponseCodiceFiscale;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodiceFiscaleController {

    private static Logger LOG = LoggerFactory.getLogger(CodiceFiscaleController.class);

    @Autowired
    private CodiceFiscaleService codiceFiscaleService;

    @PostMapping(value = "/cf", consumes = "application/json", produces = "application/json")
    public ResponseCodiceFiscale getData(@RequestBody CodiceFiscale cf) {

        if (ObjectUtils.isEmpty(cf) || StringUtils.isEmpty(cf.getCodiceFiscale())) {
            throw new RuntimeException("Codice Fiscale is required.");
        }

        return codiceFiscaleService.getCodiceFiscale(cf.getCodiceFiscale());
    }

}
