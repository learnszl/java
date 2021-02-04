package service;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;

import javax.xml.transform.TransformerConfigurationException;

/**
 * @Author szl
 * @Date 2020/12/1 15:35
 * @Description 团队成员管理
 */
public class TeamService {
    private static int counter = 1;
    private final int MAX_MEMBER = 5;
    private int total = 0;
    private Programmer [] team = new Programmer[MAX_MEMBER];

    public TeamService() {
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        TeamService.counter = counter;
    }

    public int getMAX_MEMBER() {
        return MAX_MEMBER;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[total];
        for(int i = 0; i < total; i++)
            team[i] = this.team[i];
        return team;
    }

    /**
     * 成员已满，无法添加
     * 该成员不是开发人员，无法添加
     * 该员工已在本开发团队中
     * 该员工已是某团队成员
     * 该员正在休假，无法添加
     * 团队中至多只能有一名架构师
     * 团队中至多只能有两名设计师
     * 团队中至多只能有三名程序员
     *
     */
    public void addMember(Employee e) throws TeamException{


        if(total >= MAX_MEMBER)
            throw new TeamException("成员已满，无法添加");

        if(!(e instanceof Programmer))
            throw new TeamException("该成员不是开发人员，无法添加");

        for(int i = 0; i < total; i++){
            if(team[i].getId() == e.getId())
                throw new TeamException("该员工已在本开发团队中");
        }

        if(((Programmer) e).getStatus().getNAME().equals("BUSY"))
            throw new TeamException("该员工已是某团队成员");
        else if(((Programmer) e).getStatus().getNAME().equals("VOCATION"))
            throw new TeamException("该员工正在休假，无法添加");
        //计算
        int NumOfArchitect = 0;
        int NumOfDesigner = 0;
        int NumOfProgrammer = 0;

        for(int i = 0; i < total; i++){
            if(team[i] instanceof Architect)
                NumOfArchitect++;
            else if(team[i] instanceof Designer)
                NumOfDesigner++;
            else if(team[i] instanceof Programmer)
                NumOfProgrammer++;
        }


        if(e instanceof Architect){
            if(NumOfArchitect >= 1)
                throw new TeamException("团队中至多只能有一名架构师");
        }
        else if(e instanceof Designer){
            if(NumOfDesigner >= 2)
                throw new TeamException("团队中至多只能有一名设计师");
        }
        else if(e instanceof Programmer){
            if(NumOfProgrammer >= 3)
                throw new TeamException("团队中至多只能有三名程序员");
        }
        ((Programmer) e).setStatus(Status.BUSY);
        ((Programmer) e).setMemberId(counter++);
        team[total++] = ((Programmer) e);

    }

    public void removeMember(int memberId) throws TeamException{
        for(int i = 0; i < total; i++){
            if(team[i].getMemberId() == memberId){
                team[i].setStatus(Status.FREE);
                for(int j = i; j < total - 1; j++){
                    team[j] = team[j+1];
                }
                team[--total] = null;
                return;
            }
            throw new TeamException("找不到指定memberId的员工，删除失败");
        }

    }
}
