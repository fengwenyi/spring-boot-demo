package com.fengwenyi.demospringbootexcel.vo;

import com.fengwenyi.demospringbootexcel.annotation.ExcelColumn;
import lombok.Data;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-05-20
 */
@Data
public class BusClick {

    @ExcelColumn(value = "地区编码", col = 1)
    private String cityCode;

    @ExcelColumn(value = "标志", col = 2)
    private String markId;

    @ExcelColumn(value = "toaluv", col = 3)
    private String toaluv;

    @ExcelColumn(value = "date", col = 4)
    private String date;

    @ExcelColumn(value = "clientVer", col = 5)
    private String clientVer;

}
