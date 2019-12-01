package com.baizhi;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.entity.GirlFriend;
import com.baizhi.entity.Student;
import com.baizhi.entity.Teacher;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = EasypoiApplication.class)
@SpringBootTest
public class EasypoiApplicationTests {

    @Test
    public void contextLoads() {
        List<Teacher> teachers = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        Student student = new Student(("1"), "小黑", "1");
        Student student1 = new Student(("2"), "小白", "2");
        students.add(student);
        students.add(student1);

        GirlFriend girlFriend = new GirlFriend("如花");
        GirlFriend girlFriend2 = new GirlFriend("乔碧罗");


        Teacher teacher = new Teacher("1", "葫芦娃", new Date(), students, girlFriend, "D:\\cmfz\\easypoi\\src\\main\\webapp\\img\\1(678).jpg");
        Teacher teacher2 = new Teacher("1", "哪吒", new Date(), students, girlFriend2, "D:\\cmfz\\easypoi\\src\\main\\webapp\\img\\6.jpg");

        teachers.add(teacher);
        teachers.add(teacher2);


        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班老师", "老师", "aa"),
                Teacher.class, teachers);
        try {
            workbook.write(new FileOutputStream(new File("D:/easypoi.xls")));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIn() throws Exception {
        ImportParams params = new ImportParams();
        params.setHeadRows(2);
        params.setTitleRows(2);

        List<Teacher> list = ExcelImportUtil.importExcel(new FileInputStream(new File("D:/easypoi.xls")), Teacher.class, params);
        for (Teacher teacher : list) {
            System.out.println(teacher);
            System.out.println("@@@@@@@@@@@@@@");

        }
    }

}































