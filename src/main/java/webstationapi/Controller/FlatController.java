package webstationapi.Controller;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import webstationapi.Entity.Flt_Flat;

@RestController
@EnableAutoConfiguration
public class FlatController {
	
	@GetMapping("/flats")
	@ResponseBody
	public List<Flt_Flat> sendViaResponseEntity() {
		List <Flt_Flat> flats = null;
		/* ServiceAppartement -> call Repository -> récupération retour et renvoi*/
        return flats;
    }

}
