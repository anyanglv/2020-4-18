package entity;

import javax.servlet.http.PushBuilder;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2020/4/18
 * Time: 15:59
 * To change this template use File | Settings | File Templates.
 */
public class StatusCode {

    public static final int OK = 20000;//成功
    public static final int ERROR = 20001;//失败
    public static final int LOGINERROR = 20002;//用户名密码错误
    public static final int ACCESSERROR = 20003;//权限不足
    public static final int AEMOTEERROR = 20004;//远程调用失败
    public static final int REPERROR = 20005;//重复操作
}
