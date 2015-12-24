package service.impl;

import model.MyEntity;
import org.springframework.stereotype.Service;
import other.CMap;
import other.bean.Dao;
import other.entity.FecUser;
import other.entity.Result;
import service.LoginService;

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
