package code.spring.proba.printer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrinterApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("print_resource.xml");
		PropsResourcesPrinter printer = (PropsResourcesPrinter) ctx.getBean("propsResourcePrinter");
		printer.print();
	}

}
