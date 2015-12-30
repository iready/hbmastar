import controller.FecMain;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
    public static void main(String[] args) {
        PropertyConfigurator.configure(Start.class.getResourceAsStream("log4j.properties"));
        ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
        ac.getBean(FecMain.class).begain();

    }
}
