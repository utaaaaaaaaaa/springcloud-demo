package com.uta.order.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;

public class blockHandlerForAddOrder {

    // Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
    public static String blockHandlerForAddOrder(BlockException ex) {
        if (ex instanceof FlowException) {
            return "系统限流中，请稍后重试";
        } else if (ex instanceof DegradeException) {
            return "服务暂时熔断，10秒后自动恢复";
        }
        return "系统保护中";
    }

}
