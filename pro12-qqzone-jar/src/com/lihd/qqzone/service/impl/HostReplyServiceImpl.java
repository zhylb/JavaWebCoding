package com.lihd.qqzone.service.impl;

import com.lihd.qqzone.dao.HostReplyDAO;
import com.lihd.qqzone.pojo.HostReply;
import com.lihd.qqzone.service.HostReplyService;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/6 20:26
 */
public class HostReplyServiceImpl implements HostReplyService {
    private HostReplyDAO hostReplyDAO;

    @Override
    public HostReply getHostReplyById(Integer id) {

        return hostReplyDAO.getHostReplyByReplyId(id);
    }

    @Override
    public HostReply getHostReplyAllInfo(Integer id) {
        return hostReplyDAO.getHostReplyByReplyId(id);
    }

    @Override
    public void deleteReplyByReplyId(Integer id) {
        hostReplyDAO.deleteHostReplyByReplyId(id);
    }
}
