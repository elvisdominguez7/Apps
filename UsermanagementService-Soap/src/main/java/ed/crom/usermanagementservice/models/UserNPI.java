package ed.crom.usermanagementservice.models;


public class UserNPI {

    
    protected String firstName;
    
    protected String lastName;
    protected int age;
   
    protected String secQuest;

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the age property.
     * 
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     */
    public void setAge(int value) {
        this.age = value;
    }

    /**
     * Gets the value of the secQuest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecQuest() {
        return secQuest;
    }

    /**
     * Sets the value of the secQuest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecQuest(String value) {
        this.secQuest = value;
    }

}
