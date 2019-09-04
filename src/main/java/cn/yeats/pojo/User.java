package cn.yeats.pojo;

import lombok.Data;

import java.util.Date;

@Data // lombok注解，自动提供getter和setter、hashCode、equals、toString等方法
public class User {
    private Integer id; // ID

    private String username; // 用户名
    private String password; // 密码
    private String name; // 真实姓名
    private Integer age; // 年龄
    private Integer sex; // 性别：1男，2女
    private String birthday; // 出生日期
    private String note; // 备注
    private Date created; // 创建时间
    private Date updated; // 更新时间
}
