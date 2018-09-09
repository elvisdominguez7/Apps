package ed.crom.usermanagementservice;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import ed.crom.usermanagementservice.dao.InMemoryRepository;
import ed.crom.usermanagementservice.dao.Repository;
import ed.crom.usermanagementservice.services.UserManagementService;
import ed.crom.usermanagementservice.services.UserManagementServiceImpl;



@SpringBootApplication
public class UserManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementServiceApplication.class, args);
	}
	
	@Bean
    public ServletRegistrationBean cxfServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/services/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }
    
    @Bean
    public UserManagementService userManagementService() {
    	return new UserManagementServiceImpl();
    }
    
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(),userManagementService());
        endpoint.publish("/UserManagementService");
        endpoint.setWsdlLocation("UserManagementService.wsdl");
        return endpoint;
    }
    
    @Bean(name="InMemoryRepository")
    public Repository repository(){
    	return new InMemoryRepository();
    }
}
