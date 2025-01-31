package com.deepblue.yd_jz.entity;

import lombok.Data;

/**
 * 本年总收入
 * 本年总支出
 * 本年结余
 */
@Data
public class FlowYear {
    private String totalEarns;
    private String totalCosts;
    private String totalBalance;
}
