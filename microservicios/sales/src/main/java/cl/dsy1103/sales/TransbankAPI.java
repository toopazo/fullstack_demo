package cl.dsy1103.sales;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// {
//     "url": "http://127.0.0.1:8000/users/1/",
//     "username": "admin",
//     "email": "admin@example.com",
//     "groups": []
// }

@JsonIgnoreProperties(ignoreUnknown = true)
public record TransbankAPI(String url, String username, String email, String[] groups) {
    // Constructor, getters, and other methods can be added if needed
    // The @JsonIgnoreProperties annotation is used to ignore unknown properties
    // during deserialization{

}
