package org.evan.springcloud.base.demo.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Evan.Shen
 * @since 2019-09-20
 */
@Data
public class DemoAddUpdateParams {
    private Long id;

    private Integer status;

    private Date fieldDate;

    private Date fieldDatetime;

    private String fieldSelect;

    private String fieldRadio;

    private String fieldCheckbox;

    private BigDecimal fieldNumber;

    private String fieldText;

    private String fieldProvince;

    private String fieldCity;

    private String fieldRegion;

    private String imagePath;

    private String imagePathList;

    private String fieldTextarea;

    private String fieldHtmleditor;

    private String fieldHtmleditorCut;

    @Override
    public String toString() {
        return "DemoAddUpdateParams{" +
                "status=" + status +
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
