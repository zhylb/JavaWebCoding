package com.lihd.qqzone.service;

import com.lihd.qqzone.pojo.HostReply;

public interface HostReplyService {

    HostReply getHostReplyById(Integer id);

    HostReply getHostReplyAllInfo(Integer id);

    void deleteReplyByReplyId(Integer id);
}
