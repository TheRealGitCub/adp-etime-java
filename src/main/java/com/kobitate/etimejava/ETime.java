package com.kobitate.etimejava;

/**
 * Created by kobi on 7/11/17.
 */
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class ETime {

    private final String ADP_DOMAIN =   "https://eet60.adp.com";
    private final String ADP_AUTH =     ADP_DOMAIN + "/wfc/SSOLogon/logonWithUID?IntendedURL=/wfc/applications/suitenav/navigation.do?ESS=true";
    private final String ADP_STAMP =    ADP_DOMAIN + "/wfc/applications/wtk/html/ess/timestamp-record.jsp";
    private final String ADP_VIEW =     ADP_DOMAIN + "/wfc/applications/mss/esstimecard.do";

    private Map<String, String> cookies;

    /**
     * Constructor, initiates connection to ADP and gets a cookie value
     * @param username ADP Username
     * @param password ADP Password
     * @throws ETimePasswordException User-entered username or password was incorrect
     * @throws IOException Page connection error
     */
    public ETime(String username, String password) throws ETimePasswordException,IOException {
        // Build an authorization string, convert to Base64
        String auth = username + ":" + password;
        auth = Base64.encode(auth.getBytes());

        // Send our login request
        Connection.Response res = Jsoup
                .connect(ADP_AUTH)
                .header("Authorization", "Basic " + auth)
                .method(Connection.Method.GET)
                .execute();

        // get the cookies from our response
        cookies = res.cookies();

        // if there is no session cookie, we assume the password was wrong and throw an exception
        if (cookies.get("SMSESSION") == null) {
            throw new ETimePasswordException();
        }

    }

    /**
     * Record a timestamp
     * @return If the stamp succeeded
     * @throws IOException Page connection error
     */
    public boolean stamp() throws IOException {
       Connection.Response res = Jsoup
               .connect(ADP_STAMP)
               .cookies(cookies)
               .method(Connection.Method.GET)
               .execute();

       // for now
       // @TODO detect if stamp failed
       return true;
    }

    // @TODO figure out a good way to return data in a usable fashion, perhaps custom object(s)

    /**
     * Get user's timecard
     * @return user's timecard
     * @throws IOException page connection error
     */
    public String getTimecard() throws IOException {
        Document doc = Jsoup
                .connect(ADP_VIEW)
                .cookies(cookies)
                .get();

        Element table = doc.select("table.Timecard").first();

        return table.html();

    }

}

