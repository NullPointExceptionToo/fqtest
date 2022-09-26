package daily;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyTest {
    public static void main(String[] args) {
        MyHelloWord hello = new MyHelloWord();
        MyInvacationHandler handler = new MyInvacationHandler(hello);
        HelloWord newHello = (HelloWord)Proxy.newProxyInstance(hello.getClass().getClassLoader(), new Class[]{HelloWord.class}, handler);
        newHello.sayHelloWord();


    }
}
interface HelloWord{
    public void sayHelloWord();

}
class MyHelloWord implements HelloWord{
    public void sayHelloWord() {
        System.out.println("hello word");
    }
}
class MyInvacationHandler implements InvocationHandler {
    private Object target;
    public MyInvacationHandler(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理前");
        method.invoke(target, args);
        System.out.println("代理后");
        return null;
    }
}



