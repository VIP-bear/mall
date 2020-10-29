package com.project.mall.dao.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserName {

    public boolean userNameLimit(String userName){

        //用户名长度不能超过16位,且不能低于4位
        if(!userName.isEmpty()){
            if(userName.length() > 16 || userName.length() < 4){
                return false;
            }
        }

        //用户名格式：中文、英文、数字包括下划线
        String regEx = "^[\\u4E00-\\u9FA5A-Za-z0-9_]+$";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(userName);
        return m.find();
    }

    public boolean userPwdLimit(String userPwd){

        //密码由字母数字组合（包含字母大小写），长度为6到12位，不能有特殊字符和汉字
        String regEx = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(userPwd);
        return m.find();

    }

    //身份证号输入限制(15位、18位数字，最后一位是校验位，可能为数字或字符X)
    public boolean identityLimit(String identityNum){
        String regEx = "(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(identityNum);
        return m.find();
    }

    //营业执照注册号限制（15位纯数字）
    public boolean licenseLimit(String licenseNum){
        String regEx = "^\\d{15}$";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(licenseNum);
        return m.find();
    }

    //邮箱格式限制
    public boolean emailLimit(String email){
        String regEx = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(email);
        return m.find();
    }
}
