package com.uta.order.enitty;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName order
 */
@TableName(value ="order")
@Data
public class Order implements Serializable {
    private Long id;

    private String productId;

    private Integer totalAmount;

    private Integer status;

    private static final long serialVersionUID = 1L;
}