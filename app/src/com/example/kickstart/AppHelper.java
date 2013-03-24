package com.example.kickstart;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

public class AppHelper {
	@SuppressLint("NewApi")
	@SuppressWarnings("deprecation")
	public static Point screenSize(Context ctx)
	{
		WindowManager wm = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		Point size = new Point();
        if (android.os.Build.VERSION.SDK_INT >= 13) {
        	display.getSize(size);
        } else {
        	size.x = display.getWidth();
        	size.y = display.getHeight();
        }
        return size;
	}
}

