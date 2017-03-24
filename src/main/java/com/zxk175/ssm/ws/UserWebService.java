package com.zxk175.ssm.ws;

import com.zxk175.ssm.pojo.TUser;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by zxk175 on 2017/3/24.
 */
@WebService
public interface UserWebService {
    @WebMethod
    TUser getUserById(@WebParam(name = "uid") String uid);

    @WebMethod
    List<TUser> getUsers();
}
