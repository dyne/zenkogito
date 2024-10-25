package org.dyne.kogito;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class RestroomService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${restroom.uri}")
    private String oneItsmUri;

    public String execZencode(String contract, String input) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Gson g = new Gson();
        JsonElement element = g.fromJson(input, JsonElement.class);

        Map<String, Object> jsonBody = Map.ofEntries(
                Map.entry("data", element),
                Map.entry("keys", Map.of())
                );

        String requestBody = g.toJson(jsonBody);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
        try {
            ResponseEntity<String> response =
                    restTemplate.exchange(oneItsmUri + "/api/" + contract,
                            HttpMethod.POST,
                            entity,
                            String.class);

            return response.getBody();
        } catch(HttpStatusCodeException e) {
            return "";
        }
    }

}

