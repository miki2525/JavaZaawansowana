//package pl.pjatk.mikkal;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.ImportResource;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.stereotype.Component;
//
//public class My4Component {
//
//
//    public My4Component(ApplicationContext applicationContext) {
//        System.out.println("4 Component");
//        MyFirstComponent myFirstComponent = applicationContext.getBean("myFirstComponent", MyFirstComponent.class);
//        MySecondComponent mySecondComponent = applicationContext.getBean("mySecondComponent", MySecondComponent.class);
//        myFirstComponent.hellofromFirst();
//        mySecondComponent.hellofromSecond();
//    }
//
//
////    public static void main(String[] args) {
////        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
////    }
//}
