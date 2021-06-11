package vn.webtienganh.core.service;

import vn.webtienganh.core.dto.ExaminationQuestionDTO;
import vn.webtienganh.core.dto.ResultDTO;

import java.util.List;

public interface ResultService {
    ResultDTO saveResult(String userName, Integer examinationId, List<ExaminationQuestionDTO> examinationQuestionS);
}
