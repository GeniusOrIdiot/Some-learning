package design_pattern.adapter;

import java.util.Map;

/**
 * @author LiuYJ
 * @since 2020/2/5
 */
public interface IOuterUser {
    //基本信息，比如名称、性别、手机号码等
    Map getUserBaseInfo();

    //工作区域信息
    Map getUserOfficeInfo();

    //用户的家庭信息
    Map getUserHomeInfo();
}
