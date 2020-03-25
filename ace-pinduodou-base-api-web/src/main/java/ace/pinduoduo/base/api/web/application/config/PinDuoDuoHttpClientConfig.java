package ace.pinduoduo.base.api.web.application.config;

import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qjj
 * @create 2020/3/23 20:00
 * @description 初始化拼多多httpclient
 */
@Configuration
public class PinDuoDuoHttpClientConfig {

    @Bean
    public PopClient popClient(){
        String clientId = "ed58d10f085140d49d6957a65718c17e";
        String clientSecret = "96cfa921aa846e1d2201d7e4fe1fbb2e1cd19e58";
        PopClient client = new PopHttpClient(clientId, clientSecret);
        return client;
    }

}
