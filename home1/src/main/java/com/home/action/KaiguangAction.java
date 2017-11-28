package com.home.action;

import com.home.dao.Impl.UserDAOImpl;
import com.home.factory.ServiceFactory;
import com.home.service.IKaiguangService;
import com.home.service.Impl.KaiguangServiceImpl;
import com.home.service.Impl.KongtiaoServiceImpl;
import com.home.vo.Kaiguang;
import com.home.vo.Kongtiao;
import com.opensymphony.xwork2.ActionSupport;

public class KaiguangAction extends ActionSupport {
    private Kaiguang kaiguang;
    private Kongtiao kongtiao;
    private ServiceFactory serviceFactory;

    public ServiceFactory getServiceFactory() {
        return serviceFactory;
    }

    public void setServiceFactory(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    public Kaiguang getKaiguang() {
        return kaiguang;
    }

    public void setKaiguang(Kaiguang kaiguang) {
        this.kaiguang = kaiguang;
    }

    public Kongtiao getKongtiao() {
        return kongtiao;
    }

    public void setKongtiao(Kongtiao kongtiao) {
        this.kongtiao = kongtiao;
    }

    @Override
    public String execute() throws Exception {
        this.kaiguang = this.serviceFactory.getIKaiguangServiceInstance().get(1);
        this.kongtiao = this.serviceFactory.getIKongtiaoServiceInstance().get(1);
        return SUCCESS;
    }
}
