package escuelaing.edu.parcial.controller;

import org.springframework.annotation.RestController;
import org.springframework.annotation.Autowired;
import org.springframework.annotation.GetMapping;
import org.springframework.annotation.Service;

@RestController
public class ControllerSecuencia{
    
    @Autowired
    private SecuenciaLuca secuenciaLuca;

    @GetMapping("lucasseq")
    public Map<String,Object> getMethodName(
        @RequestParam String value){
            int n;
            try{
                n = Integer.parseInt(value);
                } catch(NumberFormatException e){
                throw new IllegalArgumentException("El valor ingresado debe indicar un entero");
            }
        }

    List<Integer>lucasSecuencia = ParcialApplication.SecuenciaLuca(n);
        Map<String, Object> response = new HashMap<>();
        response.put("operation","Secuencia de Lucas");
        response.put("input", n);
        response.put("output", SecuenciaLuca.stream().map(String::valueOf).collect(collectors.joining(",")));
        return response;
       
}