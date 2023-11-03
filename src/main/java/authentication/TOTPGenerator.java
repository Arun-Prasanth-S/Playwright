package authentication;

import org.jboss.aerogear.security.otp.Totp;

public class TOTPGenerator {
    /**
     * Method is used to get the TOTP based on the security token
     * @return
     */
    public static String getTwoFactorCode(){
//Replace with your security key copied from step 12
        Totp totp = new Totp("kptd xx2i kh2u bpuw w5c6 rgcz 2kjz jo4s"); // 2FA secret key
        String twoFactorCode = totp.now(); //Generated 2FA code here
        return twoFactorCode;
    }
}
