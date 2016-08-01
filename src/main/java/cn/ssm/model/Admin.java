package cn.ssm.model;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="ssm_admin")
public class Admin {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_admin.id
     *
     * @mbggenerated
     */
    @Id
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_admin.admin_user
     *
     * @mbggenerated
     */
    private String adminUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_admin.admin_password
     *
     * @mbggenerated
     */
    private String adminPassword;

    public Admin(String id, String adminUser, String adminPassword) {
        this.id = id;
        this.adminUser = adminUser;
        this.adminPassword = adminPassword;
    }



    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_admin.id
     *
     * @return the value of ssm_admin.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_admin.id
     *
     * @param id the value for ssm_admin.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_admin.admin_user
     *
     * @return the value of ssm_admin.admin_user
     *
     * @mbggenerated
     */
    public String getAdminUser() {
        return adminUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_admin.admin_user
     *
     * @param adminUser the value for ssm_admin.admin_user
     *
     * @mbggenerated
     */
    public void setAdminUser(String adminUser) {
        this.adminUser = adminUser == null ? null : adminUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_admin.admin_password
     *
     * @return the value of ssm_admin.admin_password
     *
     * @mbggenerated
     */
    public String getAdminPassword() {
        return adminPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_admin.admin_password
     *
     * @param adminPassword the value for ssm_admin.admin_password
     *
     * @mbggenerated
     */
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", adminUser='" + adminUser + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }
}