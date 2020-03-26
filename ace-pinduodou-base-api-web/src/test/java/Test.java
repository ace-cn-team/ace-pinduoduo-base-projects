import com.pdd.pop.sdk.common.util.JsonUtil;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;
import com.pdd.pop.sdk.http.api.request.PddDdkGoodsDetailRequest;
import com.pdd.pop.sdk.http.api.request.PddDdkGoodsPidGenerateRequest;
import com.pdd.pop.sdk.http.api.request.PddDdkTopGoodsListQueryRequest;
import com.pdd.pop.sdk.http.api.response.PddDdkGoodsDetailResponse;
import com.pdd.pop.sdk.http.api.response.PddDdkGoodsPidGenerateResponse;
import com.pdd.pop.sdk.http.api.response.PddDdkTopGoodsListQueryResponse;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        String clientId = "ed58d10f085140d49d6957a65718c17e";
        String clientSecret = "96cfa921aa846e1d2201d7e4fe1fbb2e1cd19e58";
        PopClient client = new PopHttpClient(clientId, clientSecret);

        PddDdkGoodsPidGenerateRequest request = new PddDdkGoodsPidGenerateRequest();
        request.setNumber(2L);
        List<String> pIdNameList = new ArrayList<String>();
        pIdNameList.add("str");
        pIdNameList.add("测试");
        request.setPIdNameList(pIdNameList);
        PddDdkGoodsPidGenerateResponse response = client.syncInvoke(request);
        System.out.println(JsonUtil.transferToJson(response));
    }
}
