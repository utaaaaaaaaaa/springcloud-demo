package com.uta.stock.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName stock
 */
@TableName(value ="stock")
@Data
public class Stock implements Serializable {
    private Long id;

    private String productId;

    private Integer count;

    private static final long serialVersionUID = 1L;

}