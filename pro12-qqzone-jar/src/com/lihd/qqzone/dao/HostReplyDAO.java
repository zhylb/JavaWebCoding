package com.lihd.qqzone.dao;

import com.lihd.qqzone.pojo.HostReply;

public interface HostReplyDAO {


    HostReply getHostReplyByReplyId(Integer id);


    void deleteHostReplyByReplyId(Integer id);
}
