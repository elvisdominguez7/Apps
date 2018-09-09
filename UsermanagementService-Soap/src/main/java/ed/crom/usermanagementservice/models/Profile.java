package ed.crom.usermanagementservice.models;



public class Profile {

    
    protected String userName;
    
    protected String password;
   
    protected String email;
   
    protected String secQuest;
    
    protected String secAns;

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
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

    /**
     * Gets the value of the secAns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecAns() {
        return secAns;
    }

    /**
     * Sets the value of the secAns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecAns(String value) {
        this.secAns = value;
    }

}
