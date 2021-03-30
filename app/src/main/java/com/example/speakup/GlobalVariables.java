package com.example.speakup;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class GlobalVariables {
    private static GlobalVariables ourInstance;

    private static Handler handlerWorker;
    private static Handler handlerUI;
    private Activity homeActivity;
    private int globalTextSize;
    private int globalFontFamily;
    private int globalThemeColor;
    private int themeSwitch, fontFamilySwitch, fontSizeSwitch;

    public static synchronized Handler getHandlerWorker() {
        if (handlerWorker == null) {
            HandlerThread thread = new HandlerThread("Handler Worker");
            thread.start();
            handlerWorker = new Handler(thread.getLooper()) {
                @Override
                public void handleMessage(Message msg) {
                    Runnable runnable = (Runnable) msg.obj;
                    runnable.run();
                }
            };
        }

        return handlerWorker;
    }

    public static synchronized Handler getHandlerUI() {
        if (handlerUI == null)
            handlerUI = new Handler(Looper.getMainLooper()) {
                @Override
                public void handleMessage(Message msg) {
                    Runnable runnable = (Runnable) msg.obj;
                    runnable.run();
                }
            };

        return handlerUI;
    }

    public static synchronized GlobalVariables getInstance() {
        if (ourInstance == null)
            ourInstance = new GlobalVariables();
        return ourInstance;
    }

    public static void resetInstance() {
        ourInstance = null;
    }

    public Context getContext() {
        return homeActivity.getApplicationContext();
    }

    public Activity getMainActivity() {
        return homeActivity;
    }

    public void setMainActivity(Activity activity) {
        homeActivity = activity;
    }


    private GlobalVariables() {
        init();
    }

    private void init() {
        getHandlerUI().post(new Runnable() {
            @Override
            public void run() {
                globalTextSize = 16;
                globalThemeColor = getContext().getResources().getColor(R.color.blueTheme);
                globalFontFamily = R.font.arial;
            }
        });
    }

    public int getGlobalTextSize() {
        return globalTextSize;
    }

    public void setGlobalTextSize(int globalTextSize) {
        this.globalTextSize = globalTextSize;
    }

    public int getGlobalFontFamily() {
        return globalFontFamily;
    }

    public void setGlobalFontFamily(int globalFontFamily) {
        this.globalFontFamily = globalFontFamily;
    }

    public int getGlobalThemeColor() {
        return globalThemeColor;
    }

    public void setGlobalThemeColor(int globalThemeColor) {
        this.globalThemeColor = globalThemeColor;
    }

    public int getThemeSwitch() {
        return themeSwitch;
    }

    public void setThemeSwitch(int themeSwitch) {
        this.themeSwitch = themeSwitch;
    }

    public int getFontFamilySwitch() {
        return fontFamilySwitch;
    }

    public void setFontFamilySwitch(int fontFamilySwitch) {
        this.fontFamilySwitch = fontFamilySwitch;
    }

    public int getFontSizeSwitch() {
        return fontSizeSwitch;
    }

    public void setFontSizeSwitch(int fontSizeSwitch) {
        this.fontSizeSwitch = fontSizeSwitch;
    }
}
