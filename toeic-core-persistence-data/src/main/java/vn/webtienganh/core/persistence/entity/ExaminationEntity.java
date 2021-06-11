package vn.webtienganh.core.persistence.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "examination")
public class ExaminationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer examinationId;

    @Column(name = "name")
    private String name;

    @Column(name = "createddate")
    private Timestamp createddate;

    @Column(name = "modifieddate")
    private Timestamp modifieddate;

    @OneToMany(mappedBy = "examinationEntity",fetch = FetchType.LAZY)
    private List<ExaminationQuestionEntity> examinationQuestionEntityList;

    @OneToMany(mappedBy = "examinationEntity",fetch = FetchType.LAZY)
    private List<ResultEntity> resultEntityList;

    public Integer getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(Integer examinationId) {
        this.examinationId = examinationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<ExaminationQuestionEntity> getExaminationQuestionEntityList() {
        return examinationQuestionEntityList;
    }

    public void setExaminationQuestionEntityList(List<ExaminationQuestionEntity> examinationQuestionEntityList) {
        this.examinationQuestionEntityList = examinationQuestionEntityList;
    }

    public List<ResultEntity> getResultEntityList() {
        return resultEntityList;
    }

    public void setResultEntityList(List<ResultEntity> resultEntityList) {
        this.resultEntityList = resultEntityList;
    }
}
