package code.spring.person.gen.generator;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface DateGenerator {

	public void setFormat(SimpleDateFormat format);

	public Date generateDate();

}
