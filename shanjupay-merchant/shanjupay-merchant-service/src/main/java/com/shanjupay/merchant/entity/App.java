package com.shanjupay.merchant.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("app")
public class App implements Serializable {
    // 开启自动驼峰映射，注意：配置configuration.map-underscore-to-camel-case则不能配置config-location
    // mybatis-plus.configuration.map-underscore-to-camel-case=true
    // 开启自动驼峰命名规则（camel case）映射
    // 即从经典数据库列名 A_COLUMN（下划线命名） 到经典 Java属性名 aColumn（驼峰命名） 的类似映射

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.ID_WORKER)
    private Long id;

    @TableField("APP_ID")//指定对应字段名
    private String appId;

    /**
     * 商店名称
     */
    @TableField("APP_NAME")
    private String appName;

    /**
     * 所属商户
     */
    @TableField("MERCHANT_ID")
    private Long merchantId;

    /**
     * 应用公钥(RSAWithSHA256)
     */
    @TableField("PUBLIC_KEY")
    private String publicKey;

    /**
     * 授权回调地址
     */
    @TableField("NOTIFY_URL")
    private String notifyUrl;


}
