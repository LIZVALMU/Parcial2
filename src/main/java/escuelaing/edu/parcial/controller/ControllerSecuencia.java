package escuelaing.edu.parcial.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import escuelaing.edu.parcial.service.SecuenciaLuca;

@RestController
public class ControllerSecuencia{

    @Autowired
    private SecuenciaLuca secuenciaLuca;

    @GetMapping("luca")
    public Map<String,Object>getMethod(@RequestParam String value){
        int n;
        try{
            n = Integer.parseInt(value);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("El Valor indicado debe ser un entero");
        }

        }
        
        List<Integer>secuenciaLucas = Lucas.secuenciaLucas(n);

      

    }

    



}
