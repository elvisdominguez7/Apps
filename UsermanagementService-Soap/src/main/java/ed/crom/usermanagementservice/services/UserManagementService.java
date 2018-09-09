package ed.crom.usermanagementservice.services;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import ed.crom.usermanagementservice.exceptions.UserExistFault;
import ed.crom.usermanagementservice.exceptions.UserNotFoundFault;
import ed.crom.usermanagementservice.models.User;
import ed.crom.usermanagementservice.models.UserId;


@WebService(targetNamespace = "http://www.usermanagement.com", name = "UserManagementService")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface UserManagementService {

    @WebMethod(action = "http://localhost:8080/UserManagementService/updateUser")
    @Oneway
    public void updateUser(
        @WebParam(partName = "user", name = "updateUserRequest", targetNamespace = "http://www.usermanagement.com")
        User user
    ) throws UserExistFault, UserNotFoundFault;

    @WebMethod(action = "http://localhost:8080/UserManagementService/registerUser")
    @Oneway
    public void registerUser(
        @WebParam(partName = "user", name = "registerUserRequest", targetNamespace = "http://www.usermanagement.com")
        User user
    ) throws UserExistFault, UserNotFoundFault;

    @WebMethod(action = "http://localhost:8080/UserManagementService/deleteUser")
    @Oneway
    public void deleteUser(
        @WebParam(partName = "id", name = "deleteUserRequest", targetNamespace = "http://www.usermanagement.com")
        UserId id
    ) throws UserExistFault, UserNotFoundFault;

    @WebMethod(action = "http://localhost:8080/UserManagementService/retrieveUser")
    @WebResult(name = "retrieveUserResponse", targetNamespace = "http://www.usermanagement.com", partName = "user")
    public User retrieveUser(
        @WebParam(partName = "id", name = "retrieveUserRequest", targetNamespace = "http://www.usermanagement.com")
        UserId id
    ) throws UserExistFault, UserNotFoundFault;
}
