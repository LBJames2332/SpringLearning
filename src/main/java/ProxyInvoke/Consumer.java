package ProxyInvoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Consumer implements AConsumer{
    public static void main(String[] args) {

        final Producer producer = new Producer();
        //我们试图使用代理，代理中间商赚差价，会售出更多的价格
        AProducer producerwithproxy = (AProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                Producer.class.getInterfaces()
                , new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //加强代码
                        Object obj = null;
                        if ("sale".equals(method.getName())){
                            //加强sale函数
                            float percentage = 0.2f;
                            Float money = (Float) args[0];
                            System.out.println(method.getName()+"方法被代理，收取了额外的费用"+(money*percentage));
                            obj = method.invoke(producer,(1+percentage)*money);
                            return obj;
                        }
                        System.out.println(method.getName()+"方法不需要加强");
                        return null;
                    }
                });
        producerwithproxy.sale(10000);
        producerwithproxy.afterService();
    }
}
