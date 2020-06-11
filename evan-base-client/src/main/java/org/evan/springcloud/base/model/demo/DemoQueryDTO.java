package org.evan.springcloud.base.model.demo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.evan.libraries.model.query.AbstractQueryParam;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Demo查询对象
 */
@ApiModel("Demo查询对象")
public class DemoQueryDTO extends AbstractQueryParam implements Serializable {
    private static final long serialVersionUID = 13792697920061L;

    @ApiModelProperty(value = "id数组")
    private Long[] idArray;

    @ApiModelProperty(value = "单个状态", allowableValues = "1,2")
    private Integer status;

    @ApiModelProperty(value = "多个状态", allowableValues = "1,2")
    private Integer[] statusArray;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreateFrom;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreateTo;

    @ApiModelProperty(value = "修改时间")
    private Date gmtModifyFrom;

    @ApiModelProperty(value = "修改时间")
    private Date gmtModifyTo;

    @ApiModelProperty(value = "省份代码")
    private String fieldProvince;

    @ApiModelProperty(value = "城市代码")
    private String fieldCity;

    @ApiModelProperty(value = "区县代码")
    private String fieldRegion;

    @ApiModelProperty(value = "开始时间")
    private Date fieldDatetimeFrom;

    @ApiModelProperty(value = "截止时间")
    private Date fieldDatetimeTo;

    @ApiModelProperty(value = "单选")
    private Integer fieldSelect;

    @ApiModelProperty(value = "单选", allowableValues = "1,2")
    private String fieldRadio;

    @ApiModelProperty(value = "多选", allowableValues = "1,2")
    private String fieldCheckbox;

    @ApiModelProperty(value = "数字区间")
    private BigDecimal fieldNumberFrom;

    @ApiModelProperty(value = "数字区间")
    private BigDecimal fieldNumberTo;

    @ApiModelProperty(value = "文本")
    private String fieldText;

    @ApiModelProperty(value = "开始日期")
    private Date fieldDateFrom;

    @ApiModelProperty(value = "截止日期")
    private Date fieldDateTo;

    /**
     *
     */
    public Long[] getIdArray() {
        return idArray;
    }

    /***/
    public void setIdArray(Long[] idArray) {
        this.idArray = idArray;
    }

    /**
     *
     */
    public Integer getStatus() {
        return status;
    }

    /***/
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     */
    public Integer[] getStatusArray() {
        return statusArray;
    }

    /***/
    public void setStatusArray(Integer[] statusArray) {
        this.statusArray = statusArray;
    }

    /**
     *
     */
    public Date getGmtCreateFrom() {
        return gmtCreateFrom;
    }

    /***/
    public void setGmtCreateFrom(Date gmtCreateFrom) {
        this.gmtCreateFrom = gmtCreateFrom;
    }

    /**
     *
     */
    public Date getGmtCreateTo() {
        return gmtCreateTo;
    }

    /***/
    public void setGmtCreateTo(Date gmtCreateTo) {
        this.gmtCreateTo = gmtCreateTo;
    }

    /**
     *
     */
    public Date getGmtModifyFrom() {
        return gmtModifyFrom;
    }

    /***/
    public void setGmtModifyFrom(Date gmtModifyFrom) {
        this.gmtModifyFrom = gmtModifyFrom;
    }

    /**
     *
     */
    public Date getGmtModifyTo() {
        return gmtModifyTo;
    }

    /***/
    public void setGmtModifyTo(Date gmtModifyTo) {
        this.gmtModifyTo = gmtModifyTo;
    }

    /**
     *
     */
    public String getFieldProvince() {
        return fieldProvince;
    }

    /***/
    public void setFieldProvince(String fieldProvince) {
        this.fieldProvince = fieldProvince;
    }

    /**
     *
     */
    public String getFieldCity() {
        return fieldCity;
    }

    /***/
    public void setFieldCity(String fieldCity) {
        this.fieldCity = fieldCity;
    }

    /**
     *
     */
    public String getFieldRegion() {
        return fieldRegion;
    }

    /***/
    public void setFieldRegion(String fieldRegion) {
        this.fieldRegion = fieldRegion;
    }

    /**
     *
     */
    public Date getFieldDatetimeFrom() {
        return fieldDatetimeFrom;
    }

    /***/
    public void setFieldDatetimeFrom(Date fieldDatetimeFrom) {
        this.fieldDatetimeFrom = fieldDatetimeFrom;
    }

    /**
     *
     */
    public Date getFieldDatetimeTo() {
        return fieldDatetimeTo;
    }

    /***/
    public void setFieldDatetimeTo(Date fieldDatetimeTo) {
        this.fieldDatetimeTo = fieldDatetimeTo;
    }

    /**
     *
     */
    public Integer getFieldSelect() {
        return fieldSelect;
    }

    /***/
    public void setFieldSelect(Integer fieldSelect) {
        this.fieldSelect = fieldSelect;
    }

    /**
     *
     */
    public String getFieldRadio() {
        return fieldRadio;
    }

    /***/
    public void setFieldRadio(String fieldRadio) {
        this.fieldRadio = fieldRadio;
    }

    /**
     *
     */
    public String getFieldCheckbox() {
        return fieldCheckbox;
    }

    /***/
    public void setFieldCheckbox(String fieldCheckbox) {
        this.fieldCheckbox = fieldCheckbox;
    }

    /**
     *
     */
    public BigDecimal getFieldNumberFrom() {
        return fieldNumberFrom;
    }

    /***/
    public void setFieldNumberFrom(BigDecimal fieldNumberFrom) {
        this.fieldNumberFrom = fieldNumberFrom;
    }

    /**
     *
     */
    public BigDecimal getFieldNumberTo() {
        return fieldNumberTo;
    }

    /***/
    public void setFieldNumberTo(BigDecimal fieldNumberTo) {
        this.fieldNumberTo = fieldNumberTo;
    }

    /**
     *
     */
    public String getFieldText() {
        return fieldText;
    }

    /***/
    public void setFieldText(String fieldText) {
        this.fieldText = fieldText;
    }

    /**
     *
     */
    public Date getFieldDateFrom() {
        return fieldDateFrom;
    }

    /***/
    public void setFieldDateFrom(Date fieldDateFrom) {
        this.fieldDateFrom = fieldDateFrom;
    }

    /**
     *
     */
    public Date getFieldDateTo() {
        return fieldDateTo;
    }

    /***/
    public void setFieldDateTo(Date fieldDateTo) {
        this.fieldDateTo = fieldDateTo;
    }
}
