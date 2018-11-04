package webstationapi.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import webstationapi.Entity.Flt_Flat;
import webstationapi.Service.FlatService;

@RestController
@EnableAutoConfiguration
public class FlatController {


    @Autowired
    private FlatService flatService;

    @GetMapping("/flats")
    @ResponseBody
    public List<Flt_Flat> getFlats()
    {
     List<Flt_Flat> r = flatService.getFlats();
     return  r;
     }
}
