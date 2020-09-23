package com.project.mall.service;

import com.project.mall.controller.req.ConfirmShoppingCartReq;
import com.project.mall.controller.res.ReqResult;

public interface IConfirmShoppingCartService {
    ReqResult settlement(ConfirmShoppingCartReq confirmShoppingCartReq);

}
