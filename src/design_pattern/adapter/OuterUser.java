package design_pattern.adapter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuYJ
 * @since 2020/2/5
 */
public class OuterUser implements IOuterUser {
    @Override
    public Map getUserBaseInfo() {
        Map<String, String> baseInfoMap = new HashMap<>();
        baseInfoMap.put("userName", "这个员工叫混世魔王...");
        baseInfoMap.put("mobileNumber", "这个员工电话是...");
        return baseInfoMap;
    }

    @Override
    public Map getUserOfficeInfo() {
        return null;
    }

    @Override
    public Map getUserHomeInfo() {
        return null;
    }
}
