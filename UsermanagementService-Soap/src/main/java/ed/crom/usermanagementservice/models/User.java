
package ed.crom.usermanagementservice.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for User complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="User"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="userID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="age" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ssn" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "User", propOrder = {
    "userID",
    "firstName",
    "lastName",
    "age",
    "ssn",
    "phone",
    "address"
})
public class User {
	
	@XmlElement(required = true)
    protected long userID;
    @XmlElement(required = true)
    protected String firstName;
    @XmlElement(required = true)
    protected String lastName;
    protected int age;
    @XmlElement(required = true)
    protected String ssn;
    @XmlElement(required = true)
    protected String phone;
    @XmlElement(required = true)
    protected String address;

   
    public long getUserID() {
        return userID;
    }

 
    public void setUserID(long value) {
        this.userID = value;
    }

 
    public String getFirstName() {
        return firstName;
    }

 
    public void setFirstName(String value) {
        this.firstName = value;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String value) {
        this.lastName = value;
    }

 
    public int getAge() {
        return age;
    }

   
    public void setAge(int value) {
        this.age = value;
    }


    public String getSsn() {
        return ssn;
    }


    public void setSsn(String value) {
        this.ssn = value;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String value) {
        this.phone = value;
    }


    public String getAddress() {
        return address;
    }

  
    public void setAddress(String value) {
        this.address = value;
    }

}
