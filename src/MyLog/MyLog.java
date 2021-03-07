package MyLog;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;


public class MyLog {


    static final Logger logger = LoggerFactory.getLogger(MyLog.class);

    static int count;

    public static void main(String[] args) {

        String log4jConfPath = "./src/MyLog/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);

        OrderLogic logic1 = new OrderLogic();
        logic1.doOrder();

        OrderLogic logic2 = new OrderLogic();
        logic2.doOrder();
    }

}

 class OrderLogic {

    public void doOrder() {
        // какая-то логика

        // логируем инфо
        MyLog.logger.info("Заказ № " + MyLog.count + " оформлен");
        MyLog.count++;
        addToCart();
    }

    public void addToCart() {
        // Добавляем товар в корзину
        System.out.println("Заказ добавлен в корзину");

        // логируем ошибку
        MyLog.logger.error("Error");
    }
}


