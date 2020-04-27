package cn.yeats.model;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author fyyang
 */
@Table(name = "t_user")
@Data
public class User implements Serializable {
    /**
     * 开启主键自动回填
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    @Column(name = "user_name")
    private String username;

    private String password;

    private String name;

    private Integer age;

    /**
     * 将表中"gender"字段映射到pojo的属性
     */
    @Column(name = "gender")
    private Integer sex;

    private String birthday;

    @Column(name = "remark")
    private String note;

    private Date created;

    private Date updated;

    private Integer isDeleted;
}
