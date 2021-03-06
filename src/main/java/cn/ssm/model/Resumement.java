package cn.ssm.model;

import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "ssm_resumement")
public class Resumement {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_resumement.res_id
     *
     * @mbggenerated
     */
    private Long resId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_resumement.rec_id
     *
     * @mbggenerated
     */
    private Long recId;

    @Transient
    private Resume resumess;

    @Transient
    private Recruit recruitss;

    public Resumement() {
    }

    public Resumement(Long resId, Long recId, Resume resumess, Recruit recruitss) {
        this.resId = resId;
        this.recId = recId;
        this.resumess = resumess;
        this.recruitss = recruitss;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_resumement.res_id
     *
     * @return the value of ssm_resumement.res_id
     *
     * @mbggenerated
     */
    public Long getResId() {
        return resId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_resumement.res_id
     *
     * @param resId the value for ssm_resumement.res_id
     *
     * @mbggenerated
     */
    public void setResId(Long resId) {
        this.resId = resId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_resumement.rec_id
     *
     * @return the value of ssm_resumement.rec_id
     *
     * @mbggenerated
     */
    public Long getRecId() {
        return recId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_resumement.rec_id
     *
     * @param recId the value for ssm_resumement.rec_id
     *
     * @mbggenerated
     */
    public void setRecId(Long recId) {
        this.recId = recId;
    }

    public Resume getResumess() {
        return resumess;
    }

    public void setResumess(Resume resumess) {
        this.resumess = resumess;
    }

    public Recruit getRecruitss() {
        return recruitss;
    }

    public void setRecruitss(Recruit recruitss) {
        this.recruitss = recruitss;
    }

    @Override
    public String toString() {
        return "Resumement{" +
                "resId=" + resId +
                ", recId=" + recId +
                ", resumess=" + resumess +
                ", recruitss=" + recruitss +
                '}';
    }
}