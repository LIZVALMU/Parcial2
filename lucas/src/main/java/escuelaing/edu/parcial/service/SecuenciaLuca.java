package escuelaing.edu.parcial.service;

import java.util.stream.collectors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.annotation.service;


@Service
public class SecuenciaLuca{
 
    public static List<Integer>lucasSecuencia(int n){
        List<Integer> sequence = new ArrayList<>();
        if(n < 0){
            throw new IllegalArgumentException("El valor debe ser mayor igual a 0");
        }

        int s = 2;
        int l = 1;
        sequence.add(s);
        if(n == 0){
            return sequence;
        }
        sequence.add(l);
        for(int i = 2;i <= n;i++){
            int next = s +l;
            sequence.add(next);
            s = l;
            l = next;
        }
        return sequence;
    }
}
