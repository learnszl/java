import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author szl
 * @Date 2021/1/29 21:39
 * @Description For each测试
 */
public class ForeachTest {
    @Test
    public void test1() {
        Collection<Object> coll = new ArrayList<>();
        coll.add("123");
        coll.add(123);
        coll.add("szl");
        coll.add(new Person("lmz", 22));

        for (Object obj : coll) {
            System.out.println(obj);
        }
    }

    @Test
    public void test2() {
        for (int i = 0, k = 0; i < 14; i++) {
            if (i < 3) {
                for (int j = 0; j < 5 - 2 * i; j++) {
                    System.out.print(" ");
                }
                if (i == 2) {
                    for (int j = 0; j < 6 + 4 * i - 1; j++) {
                          try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print("*");
                    }
                    for (int j = 0; j < 7 - 4 * i + 2; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 0; j < 6 + 4 * i - 1; j++) {
                          try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print("*");
                    }
                } else {
                    for (int j = 0; j < 6 + 4 * i; j++) {
                          try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print("*");
                    }
                    for (int j = 0; j < 7 - 4 * i; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 0; j < 6 + 4 * i; j++) {
                          try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print("*");
                    }
                }
            } else if (i < 6) {
                for (int j = 0; j < 29; j++) {
                      try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print("*");
                }
            } else {
                if (i == 13) {
                    for (int j = 0; j < 2 * (i - 6); j++) {
                        System.out.print(" ");
                    }
                      try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print("*");
                } else {
                    for (int j = 0; j < 2 * (i - 6) + 1; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 1; j < 28 - 4 * k; j++) {

                          try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print("*");
                    }
                    k++;
                }
            }
            System.out.println();
        }
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

