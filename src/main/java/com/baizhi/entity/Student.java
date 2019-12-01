package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @ExcelIgnore
    private String id;
    @Excel(name = "学生姓名")
    private String name;
    @Excel(name = "学生性别", replace = {"男_1", "女_2"}, suffix = "生")
    private String sex;
}
