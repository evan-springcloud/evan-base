package org.evan.springcloud.base.demo.model;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Demo持久化对象
 */
@ApiModel("Demo")
public class DemoPO implements Serializable {

    private static final long serialVersionUID = 13792681968342L;

    private Long id;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "最后修改时间")
    private Date gmtModify;

    @ApiModelProperty(value = "状态  1：未发布，2：已发布")
    private Integer status;

    @ApiModelProperty(value = "日期")
    private Date fieldDate;

    @ApiModelProperty(value = "日期时间")
    private Date fieldDatetime;

    @ApiModelProperty(value = "下拉")
    private String fieldSelect;

    @ApiModelProperty(value = "单选")
    private String fieldRadio;

    @ApiModelProperty(value = "多选")
    private String fieldCheckbox;

    @ApiModelProperty(value = "数字")
    private BigDecimal fieldNumber;

    @ApiModelProperty(value = "文本")
    private String fieldText;

    @ApiModelProperty(value = "省份")
    private String fieldProvince;

    @ApiModelProperty(value = "城市")
    private String fieldCity;

    @ApiModelProperty(value = "区县")
    private String fieldRegion;

    @ApiModelProperty(value = "列表图片路径")
    private String imagePath;

    @ApiModelProperty(value = "其他图片路径")
    private String imagePathList;

    @ApiModelProperty(value = "多行文本")
    private String fieldTextarea;

    @ApiModelProperty(value = "Html文本编辑")
    private String fieldHtmleditor;

    @ApiModelProperty(value = "Html文本编辑截取")
    private String fieldHtmleditorCut;

    public DemoPO() {
    }

    public DemoPO(Long id) {
        this.id = id;
    }

    /**
     *
     */
    public Long getId() {
        return id;
    }

    /***/
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /***/
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     *
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /***/
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
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
    public Date getFieldDate() {
        return fieldDate;
    }

    /***/
    public void setFieldDate(Date fieldDate) {
        this.fieldDate = fieldDate;
    }

    /**
     *
     */
    public Date getFieldDatetime() {
        return fieldDatetime;
    }

    /***/
    public void setFieldDatetime(Date fieldDatetime) {
        this.fieldDatetime = fieldDatetime;
    }

    /**
     *
     */
    public String getFieldSelect() {
        return fieldSelect;
    }

    /***/
    public void setFieldSelect(String fieldSelect) {
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
    public BigDecimal getFieldNumber() {
        return fieldNumber;
    }

    /***/
    public void setFieldNumber(BigDecimal fieldNumber) {
        this.fieldNumber = fieldNumber;
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
    public String getImagePath() {
        return imagePath;
    }

    /***/
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     *
     */
    public String getImagePathList() {
        return imagePathList;
    }

    /***/
    public void setImagePathList(String imagePathList) {
        this.imagePathList = imagePathList;
    }

    /**
     *
     */
    public String getFieldTextarea() {
        return fieldTextarea;
    }

    /***/
    public void setFieldTextarea(String fieldTextarea) {
        this.fieldTextarea = fieldTextarea;
    }

    /**
     *
     */
    public String getFieldHtmleditor() {
        return fieldHtmleditor;
    }

    /***/
    public void setFieldHtmleditor(String fieldHtmleditor) {
        this.fieldHtmleditor = fieldHtmleditor;
    }

    /**
     *
     */
    public String getFieldHtmleditorCut() {
        return fieldHtmleditorCut;
    }

    /***/
    public void setFieldHtmleditorCut(String fieldHtmleditorCut) {
        this.fieldHtmleditorCut = fieldHtmleditorCut;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModify=" + gmtModify +
                ", status=" + status +
                ", fieldDate=" + fieldDate +
                ", fieldDatetime=" + fieldDatetime +
                ", fieldSelect='" + fieldSelect + '\'' +
                ", fieldRadio='" + fieldRadio + '\'' +
                ", fieldCheckbox='" + fieldCheckbox + '\'' +
                ", fieldNumber=" + fieldNumber +
                ", fieldText='" + fieldText + '\'' +
                ", fieldProvince='" + fieldProvince + '\'' +
                ", fieldCity='" + fieldCity + '\'' +
                ", fieldRegion='" + fieldRegion + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", imagePathList='" + imagePathList + '\'' +
                ", fieldTextarea='" + fieldTextarea + '\'' +
                ", fieldHtmleditor='" + fieldHtmleditor + '\'' +
                ", fieldHtmleditorCut='" + fieldHtmleditorCut + '\'' +
                '}';
    }
}
