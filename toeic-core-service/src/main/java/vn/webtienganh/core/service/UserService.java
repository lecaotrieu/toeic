package vn.webtienganh.core.service;

import vn.webtienganh.core.dto.CheckLogin;
import vn.webtienganh.core.dto.UserDTO;
import vn.webtienganh.core.dto.UserImportDTO;

import java.util.List;
import java.util.Map;

public interface UserService {


    Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);
    UserDTO findById(Integer userId);
    void saveUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO);
    CheckLogin checkLogin(String name, String password);
    void validateImportUser(List<UserImportDTO> userImportDTOS);
    void saveUserImport(List<UserImportDTO> userImportDTOS);
    UserDTO findByName(String name);
}
