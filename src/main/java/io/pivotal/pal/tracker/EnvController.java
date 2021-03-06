package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private Map<String, String> envMap = new HashMap<>();

    public EnvController(@Value("${PORT:NOT SET}") String port,
                         @Value("${MEMORY_LIMIT:NOT SET}") String memoryLimit,
                         @Value("${CF_INSTANCE_INDEX:NOT SET}") String cfInstanceIndex,
                         @Value("${CF_INSTANCE_ADDR:NOT SET}") String cfInstanceAddr) {
        this.envMap.put("PORT", port);
        this.envMap.put("MEMORY_LIMIT", memoryLimit);
        this.envMap.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        this.envMap.put("CF_INSTANCE_ADDR", cfInstanceAddr);
    }



    @GetMapping("/env")
    public Map<String,String> getEnv() {
        return envMap;
    }

}
