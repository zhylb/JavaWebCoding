package com.lihd.qqzone.pojo;

import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/6 12:27
 */
public class UserBasic {
    private Integer id;
    private String loginId;
    private String nickName;
    private String pwd;
    private String headImg;

    //关系
    private UserDetail userDetail;// 1 : 1
    private List<Topic> topicList;
    private List<UserBasic> friendList;




    public UserBasic() {

    }

    public UserBasic(Integer id, String loginId, String nickName, String pwd, String headImg, UserDetail userDetail, List<Topic> topicList, List<UserBasic> friendList) {
        this.id = id;
        this.loginId = loginId;
        this.nickName = nickName;
        this.pwd = pwd;
        this.headImg = headImg;
        this.userDetail = userDetail;
        this.topicList = topicList;
        this.friendList = friendList;
    }

    public UserBasic(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }

    public List<UserBasic> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<UserBasic> friendList) {
        this.friendList = friendList;
    }

    @Override
    public String toString() {
        return "UserBasic{" +
                "id=" + id +
                ", loginId='" + loginId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", headImg='" + headImg + '\'' +
                ", userDetail=" + userDetail +
                ", topicList=" + topicList +
                ", friendList=" + friendList +
                '}';
    }
}