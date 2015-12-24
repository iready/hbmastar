package service;

import other.entity.FecUser;
import other.entity.Result;

import java.util.List;

/**
 * Created by Yuquan Zou on 2015/12/24.
 */

public interface LoginService {
    //验证用户是否有效
    Result<List<FecUser>> validate(String userId);

}
