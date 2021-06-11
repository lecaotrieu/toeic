package vn.webtienganh.core.common.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.util.StringUtil;
import vn.webtienganh.core.common.constant.CoreConstant;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UploadUtil {
    private final int maxMemorySize = 1024 * 1024 * 3;//3 MB
    private final int maxRequestSize = 1024 * 1024 * 50; //50 MB
    private final Logger log = Logger.getLogger(this.getClass());

    public Object[] writeOrUpdateFile(HttpServletRequest request, Set<String> titleValue, String path) {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        boolean check = true;
        String fileLocation = null;
        String name = null;
        Map<String, String> mapReturnValue = new HashMap<String, String>();
        String address = "/" + CoreConstant.FOLDER_UPLOAD;
        checkAndCreateFolder(address, path);
        if (!isMultipart) {
            System.out.println("Have not enctype=\"multipart/form-data\"");
            check = false;
        }
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Set factory constraints
        factory.setSizeThreshold(maxMemorySize);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Set overall request size constraint
        upload.setSizeMax(maxRequestSize);
        try {
            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items) {
                if (!item.isFormField()) {
                    name = item.getName();
                    if (StringUtils.isNotBlank(name)) {
                        File uploadFile = new File(address + File.separator + path + File.separator + name);
                        fileLocation = address + File.separator + path + File.separator + name;
                        boolean isExist = uploadFile.exists();
                        try {
                            if (isExist) {
                                uploadFile.delete();
                                item.write(uploadFile);
                            } else {
                                item.write(uploadFile);
                            }
                        } catch (Exception e) {
                            check = false;
                            log.error(e.getMessage(), e);
                        }

                    }
                } else {
                    if (titleValue != null) {
                        String nameField = item.getFieldName();
                        String valueField = null;
                        try {
                            valueField = item.getString("UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            log.error(e.getMessage(), e);
                        }
                        if (titleValue.contains(nameField)) {
                            mapReturnValue.put(nameField, valueField);
                        }
                    }
                }
            }

        } catch (FileUploadException e) {
            check = false;
            log.error(e.getMessage(), e);
        }
        String fileName = "";
        if (StringUtils.isNotBlank(name)) {
            fileName = path + File.separator + name;
        }
        return new Object[]{check, fileLocation, fileName, mapReturnValue};
    }

    private void checkAndCreateFolder(String address, String path) {
        File folderRoot = new File(address);
        if (!folderRoot.exists()) {
            folderRoot.mkdirs();
        }
        File folderChild = new File(address + File.separator + path);
        if (!folderChild.exists()) {
            folderChild.mkdirs();
        }
    }
}
