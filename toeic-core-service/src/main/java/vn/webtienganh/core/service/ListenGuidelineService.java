package vn.webtienganh.core.service;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import vn.webtienganh.core.dto.ListenGuideLineDTO;

import java.util.List;
import java.util.Map;

public interface ListenGuidelineService {
    Object[] findListenGuideLineByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);
    ListenGuideLineDTO findByListenGuidelineId(int id) throws ObjectNotFoundException;
    void saveListenGuideline (ListenGuideLineDTO dto) throws ConstraintViolationException;
    ListenGuideLineDTO updateListenGuideline(ListenGuideLineDTO dto);
    Integer delete(List<Integer> ids);
}
