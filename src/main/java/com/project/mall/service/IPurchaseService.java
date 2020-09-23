package com.project.mall.service;

import com.project.mall.controller.req.PurchsaeReq;
import com.project.mall.controller.res.ReqResult;

public interface IPurchaseService {

    ReqResult buy(PurchsaeReq purchsaeReq);
}
