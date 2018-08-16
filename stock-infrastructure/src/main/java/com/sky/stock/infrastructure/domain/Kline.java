package com.sky.stock.infrastructure.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "tb_kline")
@Getter
@Setter
public class Kline {
    /**
     * 模块id,使用初始化脚本
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "close")
    private BigDecimal close;

    @Column(name = "open")
    private BigDecimal open;

    @Column(name = "low")
    private BigDecimal low;

    @Column(name = "high")
    private BigDecimal high;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "vol")
    private BigDecimal vol;

    @Column(name = "count")
    private BigDecimal count;

    @Column(name = "lineDate")
    private Date lineDate;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "updatedDate")
    private Date updatedDate;



}
