import javax.print.attribute.standard.ReferenceUriSchemesSupported;

public class CustomerList {
    private Customer[] customers;
    private int total = 0;

    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    public boolean addCustomer(Customer customer) {
        if (total >= customers.length)
            return false;
        customers[total++] = customer;
        System.out.println(customers.length);

        return true;
    }


    public boolean replaceCustomer(int index, Customer customer) {
        if (index >= total || index < 0)
            return false;
        customers[index] = customer;
        return true;
    }

    public boolean deleteCustomer(int index) {
        if (index >= total || index < 0)
            return false;
        for (int i = index; i < total - 1; i++)
            customers[i] = customers[i + 1];
        customers[total - 1] = null;
        return true;

    }

    public Customer[] getAllCustomers() {
        Customer[] custs= new Customer[total];
        for(int i = 0; i < total; i++)
            custs[i] = customers[i];
        return custs;
//        System.out.println(customers.length);
//        System.out.println(total);
//        return customers;

    }

    public int getTotal() {
        return total;
    }

    public Customer getCustomer(int index) {
        if (index >= total || index < 0)
            return null;
        return customers[index];
    }
}
//public class CustomerList{
//    private Customer[] customers;
//    private int total = 0;
//
//    public CustomerList(int totalCustomer){
//        customers = new Customer[totalCustomer];
//
//    }
//
//    public boolean addCustomer(Customer customer){
//        if(total > customers.length)
//            return false;
//        customers[total++] = customer;
//        return true;
//
//    }
//
//    public boolean replaceCustomer(Customer customer, int index){
//        if(index < 0 || index > total)
//            return false;
//        customers[index--] = customer;
//        return true;
//    }
//
//    public boolean deleteCustomer(int index){
//        if(index > total || index < 0)
//            return false;
//        for(int i = index - 1;i < customers.length - 1;i++){
//            customers[i] = customers[i+1];
//        }
//        customers[total - 1] = null;
//        return true;
//    }
//
//
//}
//public class CustomerList{
//    private Customer[] customers;
//
//    public CustomerList(int totalnumber){
//         customers = new Customer[totalnumber];
//    }
//
//
//}
