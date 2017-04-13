package com.quancai.entity;

import java.io.Serializable;

public class TSysConfig extends Criteria implements Serializable {
    private static final long serialVersionUID = 607888001694917511L;

    /**
     * 主键，也是配置项的key
     */
    private String code;

    /**
     * 备注
     */
    private String memo;

    /**
     * 名称
     */
    private String name;

    /**
     * 值，与主键一一对应
     */
    private String value;

    private String configtype;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getConfigtype() {
        return configtype;
    }

    public void setConfigtype(String configtype) {
        this.configtype = configtype == null ? null : configtype.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", code=").append(code);
        sb.append(", memo=").append(memo);
        sb.append(", name=").append(name);
        sb.append(", value=").append(value);
        sb.append(", configtype=").append(configtype);
        sb.append("]");
        return sb.toString();
    }
}