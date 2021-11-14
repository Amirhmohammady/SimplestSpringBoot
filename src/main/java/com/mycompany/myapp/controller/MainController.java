package com.mycompany.myapp.controller;

import com.mycompany.myapp.Model.tos.CarTo;
import com.mycompany.myapp.config.Conf02;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;


//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;

/**
 * Created by Amir on 4/12/2021.
 */
@Controller
public class MainController {
    @Autowired
    Conf02 conf02;

    @Value("${amir.value02}")
    private String val02;

    @GetMapping("/")
    String test01(Model model) {
        model.addAttribute("var01", conf02.getMyDirLocationFromConf01() + "    " + val02);
        return "test";
    }

    @GetMapping("/restful")
    String sendSms(Model model) {
        String url = "https://sms.farazsms.com/class/sms/webservice/send_url.php?from=3000505&to=09353995511&msg=tset&uname=amir&pass=amir";
        try {
            TrustStrategy acceptingTrustStrategy = (cert, authType) -> true;
            SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
            model.addAttribute("var01", new RestTemplate(new HttpComponentsClientHttpRequestFactory(HttpClients.custom()
                    .setSSLSocketFactory(sslsf)
                    .setConnectionManager(new BasicHttpClientConnectionManager(RegistryBuilder.<ConnectionSocketFactory>create()
                            .register("https", sslsf)
                            .register("http", new PlainConnectionSocketFactory())
                            .build())).build())).getForObject(url, String.class));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return "showvariables";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @PostMapping("/login_fail")
    String loginFail() {
        return "login";
    }

    @GetMapping("/ajax")
    String ajax01() {
        return "ajax_test";
    }

    @GetMapping("/cartest")
    String cartest(Model model, @ModelAttribute("CarTo") CarTo carto) {
        model.addAttribute("var01", carto.getModel() + carto.getFueltype());
        return "test";
    }

}
