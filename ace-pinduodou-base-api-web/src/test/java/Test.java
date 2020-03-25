import com.pdd.pop.sdk.common.util.JsonUtil;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;
import com.pdd.pop.sdk.http.api.request.PddDdkTopGoodsListQueryRequest;
import com.pdd.pop.sdk.http.api.response.PddDdkTopGoodsListQueryResponse;

public class Test {
    public static void main(String[] args) throws Exception {
        String clientId = "ed58d10f085140d49d6957a65718c17e";
        String clientSecret = "96cfa921aa846e1d2201d7e4fe1fbb2e1cd19e58";
        PopClient client = new PopHttpClient(clientId, clientSecret);

        PddDdkTopGoodsListQueryRequest request = new PddDdkTopGoodsListQueryRequest();
        request.setListId("0");
        PddDdkTopGoodsListQueryResponse response = client.syncInvoke(request);
        System.out.println(JsonUtil.transferToJson(response));
    }
}
