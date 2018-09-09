
package ed.crom.usermanagementservice.exceptions;

import javax.xml.ws.WebFault;

import ed.crom.usermanagementservice.exceptions.ErrorDetails;

@WebFault(name = "errorDetails", targetNamespace = "http://www.usermanagement.com")
public class UserNotFoundFault extends Exception {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ErrorDetails errorDetails;

    public UserNotFoundFault() {
        super();
    }
    
    public UserNotFoundFault(String message) {
        super(message);
    }
    
    public UserNotFoundFault(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundFault(String message, ErrorDetails errorDetails) {
        super(message);
        this.errorDetails = errorDetails;
    }

    public UserNotFoundFault(String message, ErrorDetails errorDetails, Throwable cause) {
        super(message, cause);
        this.errorDetails = errorDetails;
    }

    public ErrorDetails getFaultInfo() {
        return this.errorDetails;
    }
}
