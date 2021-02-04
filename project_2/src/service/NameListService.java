package service;


import domain.*;

import static service.Data.*;



public class NameListService {
    private  final Employee [] employees;

    public NameListService(){
        employees = new Employee[EMPLOYEES.length];
        for(int i = 0;i < EMPLOYEES.length;i++){
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;
            switch (type){
                case EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case PROGRAMMER:
                    equipment = FindEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equipment);
                    break;
                case DESIGNER:
                    equipment = FindEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equipment,bonus);
                    break;
                case ARCHITECT:
                    equipment = FindEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    int stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id,name,age,salary,equipment,bonus,stock);
                    break;
            }
        }


    }

    private Equipment FindEquipment(int i) {
        int type = Integer.parseInt(EQUIPMENTS[i][0]);
        String model;
        String name;
        double price;
        switch (type){
            case PC:
                model = EQUIPMENTS[i][1];
                String display = EQUIPMENTS[i][2];
                return new PC(model,display);
            case NOTEBOOK:
                model = EQUIPMENTS[i][1];
                price = Double.parseDouble(EQUIPMENTS[i][2]);
                return new NoteBook(model,price);
            case PRINTER:
                name = EQUIPMENTS[i][1];
                return new Printer(name,EQUIPMENTS[i][2]);

        }
        return null;





    }

    public Employee[] getAllEmployees(){
        return employees;
    }
    public Employee getEmployee(int id) throws TeamException{
        for(Employee e : employees){
            if(e.getId() == id)
                return e;
        }
        throw new TeamException("该员工不存在");

    }
}
