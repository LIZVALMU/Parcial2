package escuelaing.edu.parcial.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProxy{
    private List<String> backendUrls;
    private AtomicInteger currentIndex = new AtomicInteger(0);
    
    public ControllerProxy(@Value("$BACKEND_URLS:}")String backendUrlsEnv){
        if(backendUrlsEnv.isEmpty()){
            throw new IllegalArgumentException();
        } 
        this.backendUrls = List.of(backendUrlsEnv.split(","));
    }

        @GetMapping("/proxy/lucasseq")
        public Object forwardRequest(@RequestParam int n){
            String backendUrl = getNextBackendUrl();
            RestTemplate restTemplate = new RestTemplate();
            String url = backendUrl + "/hello?value=" + n;
            return restTemplate.getFordObject(url,Object.class);
        }

            private String getNextBackendUrl(){
                int index = currentIndex.getAndUpdate(i -> (i+1)% backendUrls.size());
                return backendUrls.get(index);
            }
    }


