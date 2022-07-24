package com.lihd.qqzone.dao.juint;

import com.lihd.qqzone.dao.UserBasicDAO;
import com.lihd.qqzone.dao.impl.UserBasicDAOImpl;
import com.lihd.qqzone.pojo.UserBasic;
import org.junit.Test;

public class UserBasicDAOImplTest {

    private UserBasicDAO dao = new UserBasicDAOImpl();

    @Test
    public void getUserBasicByLogin() {
    }

    @Test
    public void getUserBasicById() {
    }

    @Test
    public void getFriendListById() {
        for (UserBasic userBasic : dao.getFriendListById(1)) {

            System.out.println(userBasic);
        }

    }
}