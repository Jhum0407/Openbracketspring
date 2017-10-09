package h.j.results;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HackerrankInviteTest {
    HackerrankInvite invite;

    @Before
    public void setup(){
        invite=new HackerrankInvite();
        invite.setUsername("jhum0407@yahoo.com");
        invite.setHide_login_credentials(true);
        invite.setSend_email(true);
        invite.setForce(false);

    }
    @Test
    public void inviteCandidate() throws Exception {
        invite.inviteCandidate();
    }

}