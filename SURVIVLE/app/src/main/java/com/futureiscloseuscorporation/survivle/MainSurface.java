package com.futureiscloseuscorporation.survivle;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainSurface extends SurfaceView implements SurfaceHolder.Callback {

    private static MainSurfaceThread mainSurfaceThread;

    public MainSurface(Context context) {

        super(context);
        getHolder().addCallback(this);

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                break;
        }

        return true;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        if(mainSurfaceThread == null)
            mainSurfaceThread = new MainSurfaceThread(getHolder(),getResources()) ;

        if(mainSurfaceThread.getState() == Thread.State.NEW)
            mainSurfaceThread.start();

    }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        mainSurfaceThread.interrupt();

    }

}
