package vn.webtienganh.core.persistence.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "result")
public class ResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resultId;

    @Column(name = "listenscore")
    private Integer listensCore;

    @Column(name = "readingscore")
    private Integer readingsCore;

    @ManyToOne
    @JoinColumn(name = "examinationid")
    private ExaminationEntity examinationEntity;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity userEntity;

    @Column(name = "createddate")
    private Timestamp createddate;

    @Column(name = "modifieddate")
    private Timestamp modifieddate;

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public Integer getListensCore() {
        return listensCore;
    }

    public void setListensCore(Integer listensCore) {
        this.listensCore = listensCore;
    }

    public Integer getReadingsCore() {
        return readingsCore;
    }

    public void setReadingsCore(Integer readingsCore) {
        this.readingsCore = readingsCore;
    }

    public Timestamp getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Timestamp createddate) {
        this.createddate = createddate;
    }

    public Timestamp getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Timestamp modifieddate) {
        this.modifieddate = modifieddate;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public ExaminationEntity getExaminationEntity() {
        return examinationEntity;
    }

    public void setExaminationEntity(ExaminationEntity examinationEntity) {
        this.examinationEntity = examinationEntity;
    }
}
