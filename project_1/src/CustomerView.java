public class CustomerView {
    private CustomerList customers = new CustomerList(10);

    public static void main(String[] args) {

        CustomerView cl = new CustomerView();
        cl.enterMainMenu();
    }


    public void enterMainMenu() {
        boolean loopFlag = true;
        do {
            System.out
                    .println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");

            char key = CMUtility.readMenuSelection();
            System.out.println();
            switch (key) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("确认是否退出(Y/N)：");
                    char yn = CMUtility.readConfirmSelection();
                    if (yn == 'Y')
                        loopFlag = false;
                    break;
            }
        } while (loopFlag);
    }

    private void addNewCustomer(){
        System.out.println("----------添加客户----------");
        System.out.print("姓名：");
        String name = CMUtility.readString(4);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(11);
        System.out.print("邮箱：");
        String email = CMUtility.readString(15);

        Customer cust = new Customer(name, gender, age, phone, email);
        boolean flag = customers.addCustomer(cust);
        if(flag){
            System.out.println("----------添加完成----------");
        }
        else {
            System.out.println("----------超出存储限制----------");
        }
    }

    public void deleteCustomer() {
        System.out.println("----------删除客户----------");
        int index = 0;

        Customer cust = null;
        System.out.println("请选择待删除客户编号(-1退出）:");
        index = CMUtility.readInt();
        if (index == -1)
            return;
        cust = customers.getCustomer(index - 1);
        if (cust == null) {
            System.out.println("无法找到指定客户！");
        }

        System.out.println("是否确实删除(Y/N):");
        char confirm = CMUtility.readConfirmSelection();
        if (confirm == 'N')
            return;
        boolean flag = customers.deleteCustomer(index);
        if (flag) {
            System.out.println("----------删除完成----------");
        } else
            System.out.println("----------无法找到指定用户，删除失败----------");
    }
    public void modifyCustomer(){
        System.out.println("----------修改客户----------");
        Customer cust = null;

        int index = 0;

        System.out.println("请选择待修改客户编号(-1退出):");
        index = CMUtility.readInt();
        if(index == -1)
            return;
        cust = customers.getCustomer(index - 1);
        if(cust == null)
            System.out.println("无法找到指定客户！");
        System.out.println("姓名(" + cust.getName() + "):");

        String name = CMUtility.readString(4,cust.getName());
        System.out.print("性别(" + cust.getGender() + ")：");
        char gender = CMUtility.readChar(cust.getGender());

        System.out.print("年龄(" + cust.getAge() + ")：");
        int age = CMUtility.readInt(cust.getAge());

        System.out.print("电话(" + cust.getPhone() + ")：");
        String phone = CMUtility.readString(11, cust.getPhone());

        System.out.print("邮箱(" + cust.getEmail() + ")：");
        String email = CMUtility.readString(15, cust.getEmail());

        cust = new Customer(name, gender, age, phone, email);

        boolean flag = customers.replaceCustomer(index - 1, cust);

        if(flag)
            System.out.println("----------修改完成----------");
        else
            System.out.println("----------修改失败----------");


    }
    public void listAllCustomers(){
        System.out.println("----------客户列表----------");
        System.out.println("----------客户列表----------");
        Customer[] custs = customers.getAllCustomers();
        System.out.println(custs.length);
        for(int i = 0; i < custs.length; i++){
            System.out.println(i + 1 +"姓名:" +custs[i].getName() + "\t性别:" + custs[i].getGender() + "\t年龄:" + custs[i].getAge());

        }

    }




}


