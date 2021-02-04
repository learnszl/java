/**
 * @Author szl
 * @Date 2021/1/24 19:42
 * @Description
 */
public class Computer implements Comparable{
    private String name;
    private int price;
    private int count;

    public Computer() {
    }

    public Computer(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Computer){
            Computer computer = (Computer)o;
            if(this.price > computer.price)
                return 1;
            else if (this.price < computer.price)
                return -1;
            else
                return 0;
//          return Integer.compare(this.price, computer.price);

        }
        return 0;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
