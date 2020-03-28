package ace.pinduoduo.define.base.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.util.List;

@Data
@ApiModel
public class PddGoodsSearchRequest {

    @ApiModelProperty(value = "商品关键词，与opt_id字段选填一个或全部填写")
    private String keyword;

    @ApiModelProperty(value = "商品标签类目ID，使用pdd.goods.opt.get获取")
    private Long optId;

    @ApiModelProperty(value = "默认值1，商品页数")
    private Integer page = 1;

    @ApiModelProperty(value = "默认10，每页商品数量")
    @Range(min = 1, max = 50)
    private Integer pageSize = 10;

    @ApiModelProperty(value = "排序方式:0-综合排序;1-按佣金比率升序;2-按佣金比例降序;3-按价格升序;4-按价格降序;5-按销量升序;6-按销量降序;7-优惠券金额排序升序;8-优惠券金额排序降序;9-券后价升序排序;10-券后价降序排序;11-按照加入多多进宝时间升序;12-按照加入多多进宝时间降序;13-按佣金金额升序排序;14-按佣金金额降序排序;15-店铺描述评分升序;16-店铺描述评分降序;17-店铺物流评分升序;18-店铺物流评分降序;19-店铺服务评分升序;20-店铺服务评分降序;27-描述评分击败同类店铺百分比升序，28-描述评分击败同类店铺百分比降序，29-物流评分击败同类店铺百分比升序，30-物流评分击败同类店铺百分比降序，31-服务评分击败同类店铺百分比升序，32-服务评分击败同类店铺百分比降序")
    private Integer sortType;

    @ApiModelProperty(value = "是否只返回优惠券的商品，false返回所有商品，true只返回有优惠券的商品")
    private Boolean withCoupon;

    @ApiModelProperty(value = "筛选范围列表 样例：[{\"range_id\":0,\"range_from\":1,\"range_to\":1500},{\"range_id\":1,\"range_from\":1,\"range_to\":1500}] range_id枚举及描述： 0，最小成团价 1，券后价 2，佣金比例 3，优惠券价格 4，广告创建时间 5，销量 6，佣金金额 7，店铺描述分 8，店铺物流分 9，店铺服务分 10， 店铺描述分击败同行业百分比 11， 店铺物流分击败同行业百分比 12，店铺服务分击败同行业百分比 13，商品分 17 ，优惠券/最小团购价 18，过去两小时pv 19，过去两小时销量")
    private String rangeList;

    @ApiModelProperty(value = "商品类目ID，使用pdd.goods.cats.get接口获取")
    private Long catId;

    @ApiModelProperty(value = "商品ID列表。例如：[123456,123]，当入参带有goods_id_list字段，将不会以opt_id、 cat_id、keyword维度筛选商品")
    private List<Long> goodsIdList;

    @ApiModelProperty(value = "店铺类型，1-个人，2-企业，3-旗舰店，4-专卖店，5-专营店，6-普通店（未传为全部）")
    private Integer merchantType;

    @ApiModelProperty(value = "推广位id")
    private String pid;

    @ApiModelProperty(value = "自定义参数")
    private String customParameters;

    @ApiModelProperty(value = "店铺类型数组")
    private List<Integer> merchantTypeList;

    @ApiModelProperty(value = "是否为品牌商品")
    private Boolean isBrandGoods;

    @ApiModelProperty(value = "商品活动标记数组，例：[4,7]，4-秒杀 7-百亿补贴等")
    private List<Integer> activityTags;

    @ApiModelProperty(value = "翻页时建议填写前页返回的list_id值")
    private String listId;

}
