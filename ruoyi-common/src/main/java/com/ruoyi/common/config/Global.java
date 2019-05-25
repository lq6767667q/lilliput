package com.ruoyi.common.config;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import com.ruoyi.common.utils.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.YamlUtil;

/**
 * 全局配置类
 * 
 * @author ruoyi
 */
public class Global
{
    private static final Logger log = LoggerFactory.getLogger(Global.class);

    private static String NAME = "application.yml";

    /**
     * 当前对象实例
     */
    private static Global global;

    /**
     * 保存全局属性值
     */
    private static Map<String, String> map = new HashMap<String, String>();

    private Global()
    {
    }

    /**
     * 静态工厂方法
     */
    public static synchronized Global getInstance()
    {
        if (global == null)
        {
            global = new Global();
        }
        return global;
    }

    /**
     * 获取配置
     */
    public static String getConfig(String key)
    {
        String value = map.get(key);
        if (value == null)
        {
            Map<?, ?> yamlMap = null;
            try
            {
                yamlMap = YamlUtil.loadYaml(NAME);
                value = String.valueOf(YamlUtil.getProperty(yamlMap, key));
                map.put(key, value != null ? value : StringUtils.EMPTY);
            }
            catch (FileNotFoundException e)
            {
                log.error("获取全局配置异常 {}", key);
            }
        }
        return value;
    }

    /**
     * 获取项目名称
     */
    public static String getName()
    {
        return StringUtils.nvl(getConfig("ruoyi.name"), "RuoYi");
    }

    /**
     * 获取项目版本
     */
    public static String getVersion()
    {
        return StringUtils.nvl(getConfig("ruoyi.version"), "3.3.0");
    }

    /**
     * 获取版权年份
     */
    public static String getCopyrightYear()
    {
        return StringUtils.nvl(getConfig("ruoyi.copyrightYear"), "2018");
    }

    /**
     * 获取ip地址开关
     */
    public static Boolean isAddressEnabled()
    {
        return Boolean.valueOf(getConfig("ruoyi.addressEnabled"));
    }

    /**
     * 获取文件上传路径
     */
    public static String getProfile()
    {
        StringBuilder path = new StringBuilder();
        if(ServletUtils.isOSLinux()){
            path = new StringBuilder(getConfig("ruoyi.linuxprofile"));
        }
        else{
            path = new StringBuilder(getConfig("ruoyi.profile"));
        }
        return path.toString();
    }
    public static String getLinuxProfile()
    {
        StringBuilder path = new StringBuilder();
        if(ServletUtils.isOSLinux()){
            path = new StringBuilder(getConfig("ruoyi.linuxprofile"));
        }
        else{
            path = new StringBuilder(getConfig("ruoyi.profile"));
        }
        return path.toString();
    }

    /**
     * 获取头像上传路径
     */
    public static String getAvatarPath()
    {
        StringBuilder path = new StringBuilder();
        if(ServletUtils.isOSLinux()){
            path = new StringBuilder(getConfig("ruoyi.linuxprofile"));
        }
        else{
            path = new StringBuilder(getConfig("ruoyi.profile"));
        }
        return path.toString() + "avatar/";
    }

    /**
     * 获取下载路径
     */
    public static String getDownloadPath()
    {
        StringBuilder path = new StringBuilder();
        if(ServletUtils.isOSLinux()){
            path = new StringBuilder(getConfig("ruoyi.linuxprofile"));
        }
        else{
            path = new StringBuilder(getConfig("ruoyi.profile"));
        }
        return path.toString() + "download/";
    }

    /**
     * 获取上传路径
     */
    public static String getUploadPath()
    {
        StringBuilder path = new StringBuilder();
        if(ServletUtils.isOSLinux()){
            path = new StringBuilder(getConfig("ruoyi.linuxprofile"));
        }
        else{
            path = new StringBuilder(getConfig("ruoyi.profile"));
        }
        return path.toString() + "upload/";
    }
}
