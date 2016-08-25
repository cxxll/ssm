package cn.ssm.model;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Table(name="ssm_resume")
public class Resume {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_resume.id
     *
     * @mbggenerated
     */
    @Id
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_resume.job_category
     *
     * @mbggenerated
     */

    private  String title;
    private String jobCategory;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_resume.work_place
     *
     * @mbggenerated
     */
    private String workPlace;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_resume.salary_expectation
     *
     * @mbggenerated
     */
    private String salaryExpectation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_resume.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_resume.gender
     *
     * @mbggenerated
     */
    private String gender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_resume.working_life
     *
     * @mbggenerated
     */
    private String workingLife;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_resume.highest_degree
     *
     * @mbggenerated
     */
    private String highestDegree;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_resume.phone_number
     *
     * @mbggenerated
     */
    private String phoneNumber;

    private Long uId;

    @Transient
    private User user;

    @Transient
    private List<Recruit> recruits;


    public Resume(Long id, String title, String jobCategory, String workPlace, String salaryExpectation, String name, String gender, String workingLife, String highestDegree, String phoneNumber, Long uId, User user, List<Recruit> recruits) {
        this.id = id;
        this.title = title;
        this.jobCategory = jobCategory;
        this.workPlace = workPlace;
        this.salaryExpectation = salaryExpectation;
        this.name = name;
        this.gender = gender;
        this.workingLife = workingLife;
        this.highestDegree = highestDegree;
        this.phoneNumber = phoneNumber;
        this.uId = uId;
        this.user = user;
        this.recruits = recruits;
    }

    public Resume() {
        super();
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_resume.u_id
     *
     * @mbggenerated
     */

    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_resume.id
     *
     * @param id the value for ssm_resume.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id == null ? null : id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_resume.job_category
     *
     * @return the value of ssm_resume.job_category
     *
     * @mbggenerated
     */
    public String getJobCategory() {
        return jobCategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_resume.job_category
     *
     * @param jobCategory the value for ssm_resume.job_category
     *
     * @mbggenerated
     */
    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory == null ? null : jobCategory.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_resume.work_place
     *
     * @return the value of ssm_resume.work_place
     *
     * @mbggenerated
     */
    public String getWorkPlace() {
        return workPlace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_resume.work_place
     *
     * @param workPlace the value for ssm_resume.work_place
     *
     * @mbggenerated
     */
    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace == null ? null : workPlace.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_resume.salary_expectation
     *
     * @return the value of ssm_resume.salary_expectation
     *
     * @mbggenerated
     */
    public String getSalaryExpectation() {
        return salaryExpectation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_resume.salary_expectation
     *
     * @param salaryExpectation the value for ssm_resume.salary_expectation
     *
     * @mbggenerated
     */
    public void setSalaryExpectation(String salaryExpectation) {
        this.salaryExpectation = salaryExpectation == null ? null : salaryExpectation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_resume.name
     *
     * @return the value of ssm_resume.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_resume.name
     *
     * @param name the value for ssm_resume.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_resume.gender
     *
     * @return the value of ssm_resume.gender
     *
     * @mbggenerated
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_resume.gender
     *
     * @param gender the value for ssm_resume.gender
     *
     * @mbggenerated
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_resume.working_life
     *
     * @return the value of ssm_resume.working_life
     *
     * @mbggenerated
     */
    public String getWorkingLife() {
        return workingLife;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_resume.working_life
     *
     * @param workingLife the value for ssm_resume.working_life
     *
     * @mbggenerated
     */
    public void setWorkingLife(String workingLife) {
        this.workingLife = workingLife == null ? null : workingLife.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_resume.highest_degree
     *
     * @return the value of ssm_resume.highest_degree
     *
     * @mbggenerated
     */
    public String getHighestDegree() {
        return highestDegree;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_resume.highest_degree
     *
     * @param highestDegree the value for ssm_resume.highest_degree
     *
     * @mbggenerated
     */
    public void setHighestDegree(String highestDegree) {
        this.highestDegree = highestDegree == null ? null : highestDegree.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_resume.phone_number
     *
     * @return the value of ssm_resume.phone_number
     *
     * @mbggenerated
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_resume.phone_number
     *
     * @param phoneNumber the value for ssm_resume.phone_number
     *
     * @mbggenerated
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public List<Recruit> getRecruits() {
        return recruits;
    }

    public void setRecruits(List<Recruit> recruits) {
        this.recruits = recruits;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", jobCategory='" + jobCategory + '\'' +
                ", workPlace='" + workPlace + '\'' +
                ", salaryExpectation='" + salaryExpectation + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", workingLife='" + workingLife + '\'' +
                ", highestDegree='" + highestDegree + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", uId='" + uId + '\'' +
                ", user=" + user +
                ", recruits=" + recruits +
                '}';
    }
}