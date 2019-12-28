package com.example.mymonitor.test;

/**
 * @program: my-monitor
 * @description:
 * @author: soulx
 * @create: 2019-12-28 13:04
 **/

import io.github.biezhi.wechat.WeChatBot;
import io.github.biezhi.wechat.api.constant.Config;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloBot extends WeChatBot {

    //登陆二维保存路径
    private static String assetsDir = "D:/QRCodePath/";

    private volatile static HelloBot helloBot;

    public static void setAssetsDir(String assetsDir) {
        HelloBot.assetsDir = assetsDir;
    }

    public static HelloBot getInstance(){
        if(helloBot == null){
            synchronized (HelloBot.class){
                if(helloBot ==null){
                    helloBot = new HelloBot(Config.me().autoLogin(true).assetsDir(assetsDir).showTerminal(true));
                }
            }
        }
        return helloBot;
    }
    private HelloBot(Config config) {
        super(config);
    }

    public static void main(String[] args) {
        getInstance().start();
    }
}

