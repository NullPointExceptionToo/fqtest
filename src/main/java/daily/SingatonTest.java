package daily;

import jdk.internal.org.objectweb.asm.tree.InnerClassNode;

public class SingatonTest {
    public static void main(String[] args) {

    }
}
/**
 *DCL懒汉模式
 */
class Instance1{
    private static volatile Instance1 stance = null;
    private Instance1(){};
    public static Instance1 getInstance(){
        if(stance == null) {
            synchronized(Instance1.class){
                if(stance == null) {
                    stance = new Instance1();
                }
            }
        }
        return stance;
    }
}
/**
 *饿汉模式
 */
class Instance2{
    private Instance2(){};
    private static class InnerClass{
        private static Instance2 instance = new Instance2();
    }
    public static Instance2 getInstance() {
        return InnerClass.instance;
    }
}




