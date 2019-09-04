package cn.yeats.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "tb_user")
@Data // lombok注解，自动提供getter和setter、hashCode、equals、toString等方法
public class User {
    @Id
    //开启主键自动回填
    @KeySql(useGeneratedKeys = true)
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
