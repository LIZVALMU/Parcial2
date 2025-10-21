package escuelaing.edu.parcial.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import escuelaing.edu.parcial.service.SecuenciaLuca;

@RestController
@RequestMapping("lucasseq")
public class ControllerSecuencia{
    
    @Autowired
    private SecuenciaLuca secuenciaLuca;

    @GetMapping
    public Map<String,Object> getMethodName(
        @RequestParam String value){
            int n;
            try{
                n = Integer.parseInt(value);
                } catch(NumberFormatException e){
                throw new IllegalArgumentException("El valor ingresado debe indicar un entero");
            }
            
        List<Integer>lucasSecuencia = secuenciaLuca.lucasSecuencia(n);
            Map<String, Object> response = new HashMap<>();
            response.put("operation","Secuencia de Lucas");
            response.put("input", n);
            response.put("output",lucasSecuencia.stream().map(String::valueOf).collect(Collectors.joining(",")));
            return response;
       
        }

}