package com.juc.xx.example.easypoi;

import java.util.Date;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @Description:
 * @author: xiaoxiang
 * @Date: 2018-12-05 9:30
 */
@Data
public class BoxInfo2 {


    public BoxInfo2() {
    }


    /**
     * 仓库名称
     */

    @Excel(name = "仓库", orderNum = "0")
    private String wareHouse;

    /**
     * 行业名称
     */
    @Excel(name = "行业", orderNum = "1")
    private String industry;

    /**
     * 货主
     */
    @Excel(name = "货主", orderNum = "2")
    private String shipper;
    /**
     * 操作人工号
     */
    @Excel(name = "操作人工号", orderNum = "3")
    private Long operatorId;
    /**
     * 操作人姓名
     */
    @Excel(name = "操作人姓名", orderNum = "4")
    private String operatorName;
    /**
     * 业务类型
     */
    @Excel(name = "业务类型", orderNum = "5")
    private String businessType;

    /**
     * 开始时间
     */
    @Excel(name = "开始时间",format = "yyyy-MM-dd HH:mm:ss",orderNum = "7")
    private Date startTime;

    /**
     * 结束时间
     */
    @Excel(name = "结束时间",format = "yyyy-MM-dd HH:mm:ss",orderNum = "8")
    private Date endTime;

    /**
     * 任务维度数
     */
    @Excel(name="任务维度数",orderNum = "9")
    private Long dimension;


    /**
     * 件数
     */
    @Excel(name="工单数",orderNum = "10")
    private Long count;
    /**
     * kaish啊
     */
    @Excel(name="sku数",orderNum = "11")
    private Long sku;


    @Override
    public String toString() {
        return "BoxInfo{" +
                "wareHouse='" + wareHouse + '\'' +
                ", industry='" + industry + '\'' +
                ", shipper='" + shipper + '\'' +
                ", operatorId=" + operatorId +
                ", operatorName=" + operatorName +
                ", businessType='" + businessType + '\'' +
                ", count=" + count +
                ", sku=" + sku +
                '}';
    }
}
