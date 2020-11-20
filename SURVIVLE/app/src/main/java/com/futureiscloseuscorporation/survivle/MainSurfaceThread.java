package com.futureiscloseuscorporation.survivle;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;

class MainSurfaceThread extends Thread {

    private SurfaceHolder surfaceHolder;
    private boolean ingame;
    private Canvas mainCanvas;
    private Bitmap man;

    public MainSurfaceThread(SurfaceHolder surfaceHolder, Resources resources)  {

        this.surfaceHolder = surfaceHolder;
        ingame=false;

        man = BitmapFactory.decodeResource(resources,R.drawable.man);

    }

    public void setRunning(){

        ingame = true;

    }
    public void setStopping(){

        ingame = false;

    }
    @Override
    public void run() {
        Paint paint =  new Paint();
        while(ingame) {

            mainCanvas = surfaceHolder.lockCanvas();

            mainCanvas.drawBitmap(man,0,0,null);

            surfaceHolder.unlockCanvasAndPost(mainCanvas);
            try {
                this.sleep(16, 67);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

}