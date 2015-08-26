import java.util.*;
import javax.jws.*;
@WebService(endpointInterface="SquareRootServer")
public class SquareRootServerImp1 implements SquareRootServer{
public double getSquareRoot(double input){return Math.sqrt(input);}
public String getTime(){Date now=new Date();
return now.toString();}}
