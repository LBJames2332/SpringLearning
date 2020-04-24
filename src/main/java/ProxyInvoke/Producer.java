package ProxyInvoke;

public class Producer implements AProducer{
    public void sale(float money) {
        //生产者卖money元
        System.out.println("money"+money);
    }

    public void afterService() {

    }
}
