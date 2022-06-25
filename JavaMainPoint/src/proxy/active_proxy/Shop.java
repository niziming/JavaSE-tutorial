package proxy.active_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Shop implements InvocationHandler {

  private Object brand;

  public Shop(Object brand) {
    this.brand = brand;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    String simpleName = this.getClass().getSimpleName();
    System.out.println("销售开始" + simpleName);
    method.invoke(this.brand, args);
    System.out.println("销售结束");
    return null;
  }

  public static void main(String[] args) {
    MaotaiWine maotaiWine = new MaotaiWine();
    Shop shop = new Shop(maotaiWine);
    SellWine o = (SellWine) Proxy.newProxyInstance(
      maotaiWine.getClass().getClassLoader(),
      maotaiWine.getClass().getInterfaces(),
      shop
    );
    o.sellWine();
    System.out.println("------------------");
    SellWine o2 = new MaotaiWine();
    o2.sellWine();

    System.out.println("------------------");

    SellWine o1 = (SellWine) Proxy.newProxyInstance(
      WuNiangYe.class.getClassLoader(),
      WuNiangYe.class.getInterfaces(),
      new Shop(new WuNiangYe())
    );

    o1.sellWine();

  }
}
