package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ExcelTarget(value = "教师")
public class Teacher {
    @Excel(name = "教师主键", needMerge = true)//合并单元格
    private String id;
    @Excel(name = "教师姓名", needMerge = true)
    private String name;
    @Excel(name = "教师生日", format = "yyyy-MM-dd", needMerge = true)
    private Date bir;
    @ExcelCollection(name = "学生们", orderNum = "7")
    private List<Student> students;
    @ExcelEntity(name = "教师女朋友")
    private GirlFriend girlFriend;
    @Excel(name = "头像", type = 2, width = 50, height = 35, needMerge = true)
    private String imgUrl;
}
