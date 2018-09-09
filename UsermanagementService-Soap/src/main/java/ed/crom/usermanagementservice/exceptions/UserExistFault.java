
package ed.crom.usermanagementservice.exceptions;

import javax.xml.ws.WebFault;

import ed.crom.usermanagementservice.exceptions.ErrorDetails;



@WebFault(name = "errorDetails", targetNamespace = "http://www.usermanagement.com")
public class UserExistFault extends Exception {
    
   
	private static final long serialVersionUID = 1L;
	private ErrorDetails errorDetails;

    public UserExistFault() {
        super();
    }
    
    public UserExistFault(String message) {
        super(message);
    }
    
    public UserExistFault(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExistFault(String message, ErrorDetails errorDetails) {
        super(message);
        this.errorDetails = errorDetails;
    }

    public UserExistFault(String message, ErrorDetails errorDetails, Throwable cause) {
        super(message, cause);
        this.errorDetails = errorDetails;
    }

    public ErrorDetails getFaultInfo() {
        return this.errorDetails;
    }
}
