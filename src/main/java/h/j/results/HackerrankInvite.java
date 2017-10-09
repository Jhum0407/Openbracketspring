package h.j.results;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class HackerrankInvite {
    private String username;
    final private String subject="OpenBracket Software Developer Hiring Test Invitation";
    final private String  message="You have been invited to attend the challenge OpenBracket Software Developer Hiring Test. You can take this challenge any time. The duration of the challenge will be 75 mins from the time you start.";
    private boolean send_email;
    private boolean force;
    private boolean hide_login_credentials;
    final private String access_token="7d279cc10d2907f589b6c8d31ba48c453916394749b473a465b6f1a0ac081caa";

    public String getSubject() {
        return subject;
    }
    public String getMessage() {
        return message;
    }

    public boolean isSend_email() {
        return send_email;
    }

    public void setSend_email(boolean send_email) {
        this.send_email = send_email;
    }

    public boolean isForce() {
        return force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }

    public boolean isHide_login_credentials() {
        return hide_login_credentials;
    }

    public void setHide_login_credentials(boolean hide_login_credentials) {
        this.hide_login_credentials = hide_login_credentials;
    }

    public String getUsername() {

        return username;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void inviteCandidate() {
        final String url = "https://hackerrank.com/x/api/v3/tests/172624/candidates";
        RestTemplate restTemplate= new RestTemplate();
         restTemplate.postForObject(url,this,HackerrankInvite.class);
    }
}
