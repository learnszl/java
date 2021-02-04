package service;

import domain.Employee;

/**
 * 测试
 * @Author szl
 * @Date 2020/11/30 21:57
 * @Description
 */
public class NameListServiceTest {
    public static void main(String[] args) {
        NameListService list = new NameListService();
        for(int i = 0; i < list.getAllEmployees().length;i++)
            System.out.println(list.getAllEmployees()[i]);
        try {
            System.out.println(list.getEmployee(13));
        }catch (TeamException e) {
            e.printStackTrace();
        }
        Status s = new Status("BUSY");
        System.out.println(s.getNAME());
    }

}
