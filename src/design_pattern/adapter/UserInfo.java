package design_pattern.adapter;

/**
 * @author LiuYJ
 * @since 2020/2/5
 */
public class UserInfo implements IUserInfo {
    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getHomeAddress() {
        System.out.println("这里是员工的家庭地址...");
        return null;
    }

    @Override
    public String getMobileNumber() {
        System.out.println("这是员工的电话号码...");
        return null;
    }

    @Override
    public String getOfficeTelNumber() {
        return null;
    }

    @Override
    public String getJobPosition() {
        return null;
    }

    @Override
    public String getHomeTelNumber() {
        return null;
    }
}
