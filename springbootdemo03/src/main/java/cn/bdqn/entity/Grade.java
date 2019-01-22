package cn.bdqn.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by Administrator on 2018/3/31/031.
 */
@Data
public class Grade {
    private Integer id;
    private String gradeName,details;
    private Date createDate;
}
