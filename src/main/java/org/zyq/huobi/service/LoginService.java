package org.zyq.huobi.service;

import org.zyq.huobi.other.entity.FecUser;
import org.zyq.huobi.other.entity.Result;

import java.util.List;

/**
 * Created by Yuquan Zou on 2015/12/24.
 */

public interface LoginService {
    //验证用户是否有效
    Result<List<FecUser>> validate(String userId);

}
