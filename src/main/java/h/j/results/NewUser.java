package h.j.results;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class NewUser {
    @JsonIgnoreProperties(ignoreUnknown =true)
    private String name;
    private String email;
    private String username;
    private String  zipCode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
