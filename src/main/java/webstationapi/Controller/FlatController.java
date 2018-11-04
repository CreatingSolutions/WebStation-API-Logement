package webstationapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import webstationapi.Entity.Flt_Flat;
import webstationapi.Service.FlatService;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class FlatController {

    @Autowired
    private FlatService flatService;

    @GetMapping("/flats")
    public List<Flt_Flat> getFlats() {
        System.out.println("OK");
        return flatService.getFlats();
    }
}
