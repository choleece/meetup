package cn.choleece.transienttest;

import java.io.Serializable;

/**
 * Created by choleece on 2018/5/27.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1750971490432288018L;

    private String userName;

    private transient String password;

    public static String gender;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        User.gender = gender;
    }
}
