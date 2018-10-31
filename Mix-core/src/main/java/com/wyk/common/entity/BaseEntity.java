package com.wyk.common.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

public abstract class BaseEntity<T extends Model> extends Model<T> {
	

    /**
     * 主键ID , 这里故意演示注解可以无
     */
	@TableId(value="id")
    private Long id;
    private Long tenantId;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public BaseEntity setTenantId(Long tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
	
}