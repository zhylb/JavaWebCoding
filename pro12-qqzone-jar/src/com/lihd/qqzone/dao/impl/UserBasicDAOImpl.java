package com.lihd.qqzone.dao.impl;

import com.lihd.myssm.basedao.BaseDAO;
import com.lihd.qqzone.dao.UserBasicDAO;
import com.lihd.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/6 12:52
 */
public class UserBasicDAOImpl extends BaseDAO<UserBasic> implements UserBasicDAO {
    @Override
    public UserBasic getUserBasicByLogin(String loginId, String pwd) {

        String sql = "select * from t_user_basic where loginId = ? and pwd = ?";
        return super.queryForOne(sql,loginId,pwd);
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        String sql = "select * from t_user_basic where id = ?";
        return super.queryForOne(sql,id);
    }

    @Override
    public List<UserBasic> getFriendListById(Integer id) {

        String sql = "select u.* from t_friend f join t_user_basic u on f.fid = u.id where f.uid = ?";
        return super.queryForList(sql,id);
    }
}
