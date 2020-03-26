package ace.pinduoduo.define.base.request;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Size;
import java.util.List;

@Data
public class PddPIdGenerateRequest {

    /**
     * 要生成的推广位数量，默认为10，范围为：1~100
     */
    @Range(min = 1, max = 10)
    private Long number;

    /**
     * 推广位名称，例如["1","2"]
     */
    @Size(min = 1, max = 10)
    private List<String> pIdNameList;

}
