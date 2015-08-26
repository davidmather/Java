import java.net.*;
import javax.xml.namespace.*;
import javax.xml.ws.*;
public class SquareRootClient {
public static void main(String[] arguments)throws Exception{
	URL url=new URL("http://127.0.0.1:5335/servive?wsd1");
	QName qname=new QName("http://ws.java24hours.com/","SquareRootServerImp1Service");
	Service service=Service.create(url,qname);
	SquareRootServer srs=service.getPort(SquareRootServer.class);
	System.out.println(srs.getTime());
	System.out.println(srs.getSquareRoot(625D));
}
}
