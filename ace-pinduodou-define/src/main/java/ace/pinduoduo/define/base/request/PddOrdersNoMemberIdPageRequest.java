package ace.pinduoduo.define.base.request;


import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author qjunjia
 */
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class PddOrdersNoMemberIdPageRequest {

    private Integer pageIndex = 0;

    private Integer pageSize = 10;

}
