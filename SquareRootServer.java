import javax.jws.*;
import javax.jws.soap.*;
import javax.jws.soap.SOAPBinding.*;
@WebService
@SOAPBinding(style=Style.RPC)
public interface SquareRootServer{
	@WebMethod double getSquareRoot(double input);
	@WebMethod String getTime();
}

