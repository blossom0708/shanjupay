package com.shanjupay.test.rocketmq.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 * @class 对消息格式进行自定义
 * @version 1.0
 **/
@Data
@NoArgsConstructor
@ToString
public class OrderExt implements Serializable {

    private String id;

    private Date createTime;

    private Long money;

    private String title;

}
