package escuelaing.edu.parcial.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControllerProxy{
    private List<String> backendUrls;
    private AtomicInteger currentIndex = new AtomicInteger(0);
    
    public ControllerProxy(){
        this.backendUrls = List.of("http://localhost:8080");
    }

        @GetMapping("/proxy/lucasseq")
        public Object forwardRequest(@RequestParam int n){
            String backendUrl = getNextBackendUrl();
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8080" + "/lucaseq?value=" + n;
            System.out.println("url");
            return restTemplate.getForObject(url,Object.class);
        }

            private String getNextBackendUrl(){
                int index = currentIndex.getAndUpdate(i -> (i+1)% backendUrls.size());
                return backendUrls.get(index);
            }
    }


