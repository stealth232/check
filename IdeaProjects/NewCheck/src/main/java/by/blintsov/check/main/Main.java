package by.blintsov.check.main;

import by.blintsov.check.creator.OrderCreator;
import by.blintsov.check.entity.*;
import by.blintsov.check.entity.impl.Product;
import by.blintsov.check.exception.ProductException;
import by.blintsov.check.parser.ArgsParser;
import java.util.*;

public class Main {

   public static void main(String[] args) throws ProductException {
        //args = new String[]{"5-100", "1-100", "2-100","3-100","4-100", "3-35", "4-7"};
        //args = new String[]{"src\\main\\resources\\file.txt"};
        
        List<Product> products = new ArrayList<>(); //список продуктов
        products.add(new Bounty());
        products.add(new Snickers());
        products.add(new Nuts());
        products.add(new Mars());
        products.add(new Twix());

        ArgsParser ap = new ArgsParser(); //экземпляры классов необходимых для работы
        OrderCreator oc = new OrderCreator();

        List<String> list = ap.parsParams(args);//получаем параметры в виде списка
        Map<String, Integer> map = oc.order(list);//переводим параметры в пары ключ-значение (товар-количество)
        Check check = new Check(map);//создаем экземпляр чека, в котором в виде карты будут хранится все его данные

        StringBuilder sb = check.showCheck(products);//сопоставляем полученные параметры с товарами и получаем чек
        System.out.println(sb);// выводим чек в консоль
        check.printCheck(sb);//печатаем в файл
        check.printPDFCheck(sb);//печатаем в файл
    }
}
