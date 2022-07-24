package com.lihd.qqzone.dao.impl;

import com.lihd.myssm.basedao.BaseDAO;
import com.lihd.qqzone.dao.HostReplyDAO;
import com.lihd.qqzone.pojo.HostReply;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/6 13:23
 */
public class HostReplyDAOImpl extends BaseDAO<HostReply> implements HostReplyDAO {


    @Override
    public HostReply getHostReplyByReplyId(Integer id) {

        String sql = "select * from t_host_reply where reply = ?";

        return super.queryForOne(sql,id);
    }

    @Override
    public void deleteHostReplyByReplyId(Integer id) {
        String sql = "delete from t_host_reply where reply = ?";
        super.updateQuery(sql,id);
    }


}
