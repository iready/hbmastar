package controller;

import model.HttpUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import other.bean.Dao;

import javax.annotation.Resource;

@Service
public class FecMain {
    @Resource
    HttpUtils httpUtils;
    @Resource
    Dao dao;
    @Resource
    ApplicationContext ah;

    public void begain() {
        try {
//            ah.getBean(Index.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
