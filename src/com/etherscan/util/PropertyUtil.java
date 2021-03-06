package com.etherscan.util;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
    private static final Logger logger = Logger.getLogger(PropertyUtil.class);
    private static Properties props;
    static{
        loadProps();
    }
    synchronized static private void loadProps(){
        logger.info("开始加载properties文件内容.......");
        System.out.println("开始加载properties文件内容.......");
        props = new Properties();
        InputStream in = null;
        try {
                in = PropertyUtil.class.getClassLoader().getResourceAsStream("resources/init.properties");
                //in = PropertyUtil.class.getResourceAsStream("/jdbc.properties");
                props.load(in);
        } catch (FileNotFoundException e) {
            logger.error("init.properties文件未找到");
            System.out.println("init.properties文件未找到");
        } catch (IOException e) {
            System.out.println("出现IOException");
            logger.error("出现IOException");
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {
                System.out.println("init.properties文件流关闭出现异常");
                logger.error("init.properties文件流关闭出现异常");
            }
        }
        logger.info("加载properties文件内容完成...........");
        System.out.println("加载properties文件内容完成...........");
        System.out.println("properties文件内容：" + props);
        logger.info("properties文件内容：" + props);
    }

    public static String getProperty(String key){
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }
}
