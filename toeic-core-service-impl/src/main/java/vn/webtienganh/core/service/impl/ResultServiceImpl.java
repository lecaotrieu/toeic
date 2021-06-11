package vn.webtienganh.core.service.impl;

import vn.webtienganh.core.dto.ExaminationQuestionDTO;
import vn.webtienganh.core.dto.ResultDTO;
import vn.webtienganh.core.persistence.entity.ExaminationEntity;
import vn.webtienganh.core.persistence.entity.ResultEntity;
import vn.webtienganh.core.persistence.entity.UserEntity;
import vn.webtienganh.core.service.ResultService;
import vn.webtienganh.core.service.utils.SingletonDaoUtil;
import vn.webtienganh.core.utils.ResultBeanUtil;

import java.sql.Timestamp;
import java.util.List;

public class ResultServiceImpl implements ResultService {
    @Override
    public ResultDTO saveResult(String userName, Integer examinationId, List<ExaminationQuestionDTO> examinationQuestionS) {
        ResultDTO resultDTO = new ResultDTO();
        if (userName != null && examinationId != null && examinationQuestionS != null) {
            UserEntity user = SingletonDaoUtil.getUserDaoInstance().findEqualUnique("name", userName);
            ExaminationEntity examination = SingletonDaoUtil.getExaminationDaoImpl().findById(examinationId);
            ResultEntity resultEntity = new ResultEntity();
            calculateListenAndReadScore(resultEntity, examinationQuestionS);
            initDataToResultEntity(resultEntity, user, examination);
            resultEntity = SingletonDaoUtil.getResultDaoImpl().save(resultEntity);
            resultDTO = ResultBeanUtil.entity2Dto(resultEntity);
        }
        return resultDTO;
    }

    private void initDataToResultEntity(ResultEntity resultEntity, UserEntity user, ExaminationEntity examination) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        resultEntity.setCreateddate(timestamp);
        resultEntity.setExaminationEntity(examination);
        resultEntity.setUserEntity(user);
    }

    private void calculateListenAndReadScore(ResultEntity resultEntity, List<ExaminationQuestionDTO> examinationQuestionS) {
        int listenScore = 0;
        int readingScore = 0;
        for (ExaminationQuestionDTO item : examinationQuestionS) {
            if (item.getAnswerUser() != null) {
                if (item.getAnswerUser().equals(item.getCorrectAnswer())) {
                    if (item.getNumber() <= 4) {
                        listenScore++;
                    } else {
                        readingScore++;
                    }
                }
            }
        }
        resultEntity.setReadingsCore(readingScore);
        resultEntity.setListensCore(listenScore);
    }
}
