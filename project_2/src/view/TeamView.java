package view;

import com.sun.jdi.PathSearchingVirtualMachine;
import domain.Employee;
import domain.Programmer;
import service.NameListService;
import service.TeamException;
import service.TeamService;

import javax.sound.midi.Soundbank;
import java.beans.beancontext.BeanContext;
import java.sql.PseudoColumnUsage;

/**
 * @Author szl
 * @Date 2020/12/3 15:04
 * @Description
 */
public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();


    public void enterMainMenu(){
        boolean loopFlag = true;
        char key = 0;
        do{
            if(key != '1')
                listAllEmployees();
            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
            key = TSUtility.readMenuSelection();
            switch(key){
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("是否确认退出(Y/N)");
                    char yn = TSUtility.readConfirmSelection();
                    if(yn == 'Y')
                        loopFlag = false;
                    break;
            }
        }while (loopFlag);
    }

    private void listAllEmployees(){
        System.out.println("---------客户调度软件----------");
        Employee[] employees= listSvc.getAllEmployees();
        if(employees.length == 0)
            System.out.println("没有客户记录");
        else {
            System.out.println("ID\t姓名\t\t年龄\t工资\t\t职位\t\t状态\t\t奖金\t\t股票\t\t领用设备");
            for(Employee e : employees)
                System.out.println(e);

        }
        System.out.println("-------------------------");
    }

    private void getTeam(){
        System.out.println("-----------团队成员列表---------------");
        Programmer[] programmers = teamSvc.getTeam();
        if(programmers.length == 0)
            System.out.println("该团队目前还没有成员");
        else{
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
            for(Programmer p : programmers)
                System.out.println(" " + p.getMemberId() +"/" + p);
        }
        System.out.println("------------------");


    }

    private void addMember(){
        System.out.println("---------添加成员-----------");
        System.out.println("请输入要添加员工的ID：");
        int id = TSUtility.readInt();
        try {
            Employee e = listSvc.getEmployee(id);
            teamSvc.addMember(e);
            System.out.println("添加成功");
        } catch (TeamException teamException) {
            System.out.println("添加失败，原因：" + teamException.getMessage());
        }



    }

    private void deleteMember(){
        System.out.println("--------------删除成员-----------");
        System.out.println("请输入要删除员工的TID：");
        int tid = TSUtility.readInt();
        System.out.println("是否确认删除(Y/N):");
        char yn = TSUtility.readConfirmSelection();
        if(yn == 'N')
            return;
        try {
            teamSvc.removeMember(tid);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println("删除失败，原因：" + e.getMessage());
        }

    }

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }

}
