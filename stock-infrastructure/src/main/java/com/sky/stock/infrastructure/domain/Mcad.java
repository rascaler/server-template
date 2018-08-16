package com.sky.stock.infrastructure.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Table(name = "tb_mcad")
public class Mcad {

    /**
     * 模块id,使用初始化脚本
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "klineId")
    private Long klineId;

    @Column(name = "ema12")
    private BigDecimal ema12;

    @Column(name = "ema26")
    private BigDecimal ema26;

    @Column(name = "dea")
    private BigDecimal dea;

    @Column(name = "diff")
    private BigDecimal diff;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "updatedDate")
    private Date updatedDate;
}
