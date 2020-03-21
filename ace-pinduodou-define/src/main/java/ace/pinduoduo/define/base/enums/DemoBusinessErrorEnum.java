package ace.pinduoduo.define.base.enums;

import ace.fw.enums.BaseEnum;
import lombok.Getter;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/3/17 15:10
 * @description
 */
public enum DemoBusinessErrorEnum implements BaseEnum<String> {
    DEMO_BUSINESS_ERROR_ENUM("-111111111", "Demo"),
    ;
    @Getter
    private String code;
    @Getter
    private String desc;

    DemoBusinessErrorEnum(String code, String desc) {

        this.code = code;
        this.desc = desc;
    }
}
