package com.lihd.book.test;

import com.lihd.book.pojo.User;
import com.lihd.book.service.UserService;
import com.lihd.book.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.UUID;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/6/13 11:13
 */
public class InsertData {
    Random r = new Random();
    UserService userService = new UserServiceImpl();

    @Test
    public void test01(){
        //批量插入用户假数据
        String[] name = getName();
        HashSet<String> set = new HashSet<>(Arrays.asList(name));
        for (String s : set) {
            User user = getUser();
            user.setUname(s);
            userService.register(user);
        }
    }

    

    public String[]  getName() {
        String s = "关羽、张飞、马超、黄忠、赵云、魏延、许靖、马良、徐庶、关平、周仓、关兴、张苞、陈到、李严、姜维、廖化、马谡、马岱、陈式、孙乾、简雍、糜竺、糜芳、庞统、陈震、杨仪、费祎、蒋琬、孟优、黄皓、诸葛亮、" +
                "张辽、徐晃、夏侯惇、夏侯渊、庞德、张郃、李典、乐进、典韦、曹洪、曹仁、曹彰、曹纯、于禁、许褚、吕虔、李通、文聘、臧霸、" +
                "荀彧、荀攸、贾诩、郭嘉、程昱、戏志才、刘晔、蒋济、陈群、华歆、钟繇、满宠、董昭、王朗、崔琰、毛玠、杜畿、" +
                "郭淮、钟会、邓艾、曹休、张燕、张绣、朱灵、路昭、史涣、韩浩、王凌、孙礼、秦朗、郑文、夏侯尚、毌丘俭、诸葛诞、" +
                "田畴、王修、杨修、辛毗、杨阜、田豫、王粲、蒯越、张继、杜袭、枣祗、任峻、陈矫、郗虑、桓玠、丁仪、丁廙、司马朗、韩暨、韦康、邴原、赵俨、娄圭、贾逵、陈琳、司马懿、" +
                "周瑜、吕蒙、甘宁、太史慈、程普、黄盖、韩当、周泰、蒋钦、丁奉、徐盛、陈武、凌操、凌统、潘璋、朱然、孙桓、马忠、孙韶、朱桓、夏恂、周平、全琮、于诠、" +
                "陆逊、张昭、张紘、鲁肃、虞翻、顾雍、诸葛谨、诸葛恪、陆凯、骆统、周鲂、" +
                "张角、何进、董卓、袁绍、吕布、袁术、刘表、刘璋、马腾、张鲁、韩遂、公孙瓒、韩馥、刘岱、王匡、张邈、张宝、张梁、程远志、邓茂、马元义、赵弘、韩忠、孙夏、管亥、何仪、刘辟、龚都、裴元绍、高升、张闿、韩暹、李乐、杨奉、" +
                "孔伷、陶谦、鲍信、桥瑁、袁遗、孔融、张超、张杨、刘度、赵范、金旋、韩玄、董承、王子服、李儒、陈宫、田丰、沮授、审配、许攸、郭图、逢纪、伍孚、李傕、郭汜、颜良、文丑、潘凤、俞涉、武安国、穆顺、华雄、牛辅、张济、樊稠、" +
                "胡轸、胡车儿、李肃、高顺、张任、高览、曹性、闵纯、纪灵、辛评、荀谌、陈登、蒯良、王累、韩胤、沮鹄、杨弘、阎象、马休、马铁、袁谭、袁熙、袁尚、麴义、吕翔、吕旷、韩猛、淳于琼、焦触、张南、" +
                "马延、雷薄、张勋、陈纪、桥蕤、郝萌、侯成、宋宪、魏续、成廉、蔡瑁、张允、黄祖、苏飞、吕公、侯选、程银、李堪、张横、梁兴、成宜、马玩、杨秋、";
        return s.split("、");
    }

    public User getUser() {
        String pass = UUID.randomUUID().toString().substring(0,6);
        String[] emailSuffix = {"@126.com","@gmail.com", "@qq.com","@lzu.edu.cn"};
        String email = pass + emailSuffix[r.nextInt(4)];

        Integer role = r.nextInt(5) == 0 ? 1 : 0;
        Integer addressId = r.nextInt(20) + 1;
        User user = new User();
        user.setPwd(pass);
        user.setEmail(email);
        user.setRole(role);
        user.setAddressId(addressId);

        return user;
    }


}
