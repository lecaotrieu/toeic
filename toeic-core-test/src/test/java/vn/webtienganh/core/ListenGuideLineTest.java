package vn.webtienganh.core;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import vn.webtienganh.core.dao.ListenGuidelineDao;
import vn.webtienganh.core.daoimpl.ListenGuidelineDaoImpl;

import java.util.HashMap;
import java.util.Map;

public class ListenGuideLineTest {
    ListenGuidelineDao listenGuidelineDao;

    @BeforeTest
    public void initData() {
        listenGuidelineDao = new ListenGuidelineDaoImpl();
    }

    @Test
    public void findByPropertiesTest() {
//        Object[] result = dao.findByProperty(null, null, null, null, 2, 2);
    }

    @Test
    public void checkApiFindByproperty() {
        Map<String, Object> property = new HashMap<String, Object>();
        property.put("title", "Bai hd 4");
        property.put("content","Noi dung bai hd 4");
        Object[] objects = listenGuidelineDao.findByProperty(property,null,null,null,null);
    }
}
