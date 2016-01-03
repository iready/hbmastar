package org.zyq.huobi.service.impl;

import org.zyq.huobi.model.MyEntity;
import org.springframework.stereotype.Service;
import org.zyq.huobi.model.CMap;
import org.zyq.huobi.other.bean.Dao;
import org.zyq.huobi.other.entity.FecUser;
import org.zyq.huobi.other.entity.Result;
import org.zyq.huobi.service.LoginService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Yuquan Zou on 2015/12/24.
 */
@Service
public class LoginImpl implements LoginService {
    @Resource
    private Dao dao;

    public Result<List<FecUser>> validate(String userId) {
        Result<List<FecUser>> res = new Result<List<FecUser>>();
        List<FecUser> fecUser = dao.find("from FecUser where userId= :userId", new CMap().put("userId", userId.trim()), new MyEntity<FecUser>());
        if (fecUser.size() > 0) {
            res.setResult(true);
            res.setData(fecUser);
        } else {
            res.setResult(false);
        }
        return res;
    }
}
