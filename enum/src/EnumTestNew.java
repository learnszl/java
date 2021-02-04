/**
 * @Author szl
 * @Date 2021/1/27 20:59
 * @Description
 */
public class EnumTestNew {
    public static void main(String[] args) {
        Season1 autumn = Season1.AUTUMN;
        autumn.show();
    }

}
interface sho{
    void show();
}
enum  Season1 implements sho{

   SPRING("春天","万物复苏"){
       @Override
       public void show() {
           System.out.println("1111");

       }
   },
   SUMMER("夏天","夏日炎炎"){
       @Override
       public void show() {
           System.out.println("2222");

       }
   },
   AUTUMN("秋天","秋高气爽"){
       @Override
       public void show() {
           System.out.println("3333");

       }
   },
   WINTER ("冬天","银装素裹"){
       @Override
       public void show() {
           System.out.println("4444");

       }
   };

    private final String seasonName;
    private final String seasonDesc;

    Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }



    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}

