package com.zxk175.ssm.properties;

/**
 * Created by zxk175 on 2017/3/17.
 */

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class PropertiesHandler extends PropertyPlaceholderConfigurer {
    private String[] encryptPropNames = {"jdbc.username", "jdbc.password"};
    private String code = "z95x09k19-c93-l12-q30";

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        //如果在加密属性名单中发现该属性
        if (isEncryptProp(propertyName)) {
            String decryptValue = "";
            try {
                //decryptValue = E.decrypt(code, propertyValue);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(decryptValue);
            return decryptValue == "" ? propertyValue : decryptValue;
        } else {
            return propertyValue;
        }
    }

    private boolean isEncryptProp(String propertyName) {
        for (String encryptName : encryptPropNames) {
            if (encryptName.equals(propertyName)) {
                return true;
            }
        }
        return false;
    }
}