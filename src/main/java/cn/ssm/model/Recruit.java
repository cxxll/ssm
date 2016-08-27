package cn.ssm.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import java.util.List;

@Table(name = "ssm_recruit")
public class Recruit {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_recruit.id
     *
     * @mbggenerated
     */
    @Id
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_recruit.name
     *
     * @mbggenerated
     */
    @NotEmpty(message = "不能为空")
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_recruit.industry
     *
     * @mbggenerated
     */
    @NotEmpty(message = "不能为空")
    private String industry;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_recruit.nature
     *
     * @mbggenerated
     */
    @NotEmpty(message = "不能为空")
    private String nature;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_recruit.company_size
     *
     * @mbggenerated
     */
    @NotEmpty(message = "不能为空")
    private String companySize;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_recruit.company_profile
     *
     * @mbggenerated
     */
    @NotEmpty(message = "不能为空")
    private String companyProfile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_recruit.contacts
     *
     * @mbggenerated
     */
    @Length(min= 2,max= 4,message = "名字必须在2个中文字到4个中文字")
    private String contacts;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_recruit.recruitment_telephone
     *
     * @mbggenerated
     */
    @Pattern(regexp="^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$", message="手机号格式不正确")
    private String recruitmentTelephone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_recruit.company_address
     *
     * @mbggenerated
     */
    @NotEmpty(message = "不能为空")
    private String companyAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_recruit.u_id
     *
     * @mbggenerated
     */

    private Long uId;

    @Transient
    private User user;

    @Transient
    private List<Resume> resumes;

    public Recruit() {
        super();
    }

    public Recruit(String recruitmentTelephone, Long id, String name, String industry, String nature, String companySize, String companyProfile, String contacts, String companyAddress, Long uId, User user, List<Resume> resumes) {
        this.recruitmentTelephone = recruitmentTelephone;
        this.id = id;
        this.name = name;
        this.industry = industry;
        this.nature = nature;
        this.companySize = companySize;
        this.companyProfile = companyProfile;
        this.contacts = contacts;
        this.companyAddress = companyAddress;
        this.uId = uId;
        this.user = user;
        this.resumes = resumes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_recruit.id
     *
     * @return the value of ssm_recruit.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_recruit.id
     *
     * @param id the value for ssm_recruit.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id == null ? null : id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_recruit.name
     *
     * @return the value of ssm_recruit.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_recruit.name
     *
     * @param name the value for ssm_recruit.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_recruit.industry
     *
     * @return the value of ssm_recruit.industry
     *
     * @mbggenerated
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_recruit.industry
     *
     * @param industry the value for ssm_recruit.industry
     *
     * @mbggenerated
     */
    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_recruit.nature
     *
     * @return the value of ssm_recruit.nature
     *
     * @mbggenerated
     */
    public String getNature() {
        return nature;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_recruit.nature
     *
     * @param nature the value for ssm_recruit.nature
     *
     * @mbggenerated
     */
    public void setNature(String nature) {
        this.nature = nature == null ? null : nature.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_recruit.company_size
     *
     * @return the value of ssm_recruit.company_size
     *
     * @mbggenerated
     */
    public String getCompanySize() {
        return companySize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_recruit.company_size
     *
     * @param companySize the value for ssm_recruit.company_size
     *
     * @mbggenerated
     */
    public void setCompanySize(String companySize) {
        this.companySize = companySize == null ? null : companySize.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_recruit.company_profile
     *
     * @return the value of ssm_recruit.company_profile
     *
     * @mbggenerated
     */
    public String getCompanyProfile() {
        return companyProfile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_recruit.company_profile
     *
     * @param companyProfile the value for ssm_recruit.company_profile
     *
     * @mbggenerated
     */
    public void setCompanyProfile(String companyProfile) {
        this.companyProfile = companyProfile == null ? null : companyProfile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_recruit.contacts
     *
     * @return the value of ssm_recruit.contacts
     *
     * @mbggenerated
     */
    public String getContacts() {
        return contacts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_recruit.contacts
     *
     * @param contacts the value for ssm_recruit.contacts
     *
     * @mbggenerated
     */
    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_recruit.recruitment_telephone
     *
     * @return the value of ssm_recruit.recruitment_telephone
     *
     * @mbggenerated
     */
    public String getRecruitmentTelephone() {
        return recruitmentTelephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_recruit.recruitment_telephone
     *
     * @param recruitmentTelephone the value for ssm_recruit.recruitment_telephone
     *
     * @mbggenerated
     */
    public void setRecruitmentTelephone(String recruitmentTelephone) {
        this.recruitmentTelephone = recruitmentTelephone == null ? null : recruitmentTelephone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_recruit.company_address
     *
     * @return the value of ssm_recruit.company_address
     *
     * @mbggenerated
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_recruit.company_address
     *
     * @param companyAddress the value for ssm_recruit.company_address
     *
     * @mbggenerated
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_recruit.u_id
     *
     * @return the value of ssm_recruit.u_id
     *
     * @mbggenerated
     */
    public Long getuId() {
        return uId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_recruit.u_id
     *
     * @param uId the value for ssm_recruit.u_id
     *
     * @mbggenerated
     */
    public void setuId(Long uId) {
        this.uId = uId == null ? null : uId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Resume> getResumes() {
        return resumes;
    }

    public void setResumes(List<Resume> resumes) {
        this.resumes = resumes;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", industry='" + industry + '\'' +
                ", nature='" + nature + '\'' +
                ", companySize='" + companySize + '\'' +
                ", companyProfile='" + companyProfile + '\'' +
                ", contacts='" + contacts + '\'' +
                ", recruitmentTelephone='" + recruitmentTelephone + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", uId='" + uId + '\'' +
                ", user=" + user +
                ", resumes=" + resumes +
                '}';
    }
}