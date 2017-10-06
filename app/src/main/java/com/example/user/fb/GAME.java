package com.example.user.fb;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by user on 22-06-2015.
 */
public class GAME extends Activity implements View.OnTouchListener{int h,w;
    Bitmap ball, bkg,rng,tails,gold;float x,y,a,b;int t=3,o=0,l=0;MediaPlayer s,bk,pot,gld;float c[]=new float[20];float d[]=new float[20];int i;float  po,k=0;int r=0;
    float e[]=new float[20];float f[]=new float[20];Paint p;int os,rdm;SharedPreferences sp,rm;Toast to;
    int g[]=new int[10];int lg=0,rg=0,tg=0;int mul=2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        s=MediaPlayer.create(GAME.this,R.raw.chnge);
        bk=MediaPlayer.create(GAME.this,R.raw.music);
        bk.setLooping(true);bk.start();
        gld=MediaPlayer.create(GAME.this,R.raw.gold);

        pot=MediaPlayer.create(GAME.this,R.raw.brek);
        View v = new Abi(this);
        setContentView(v);
        v.setOnTouchListener(this);
        rm=this.getSharedPreferences("ACHAN",Context.MODE_PRIVATE);
        rdm=rm.getInt("ky",0);
        if(rdm==1){rdm=rdm+1;}
        if(rdm==4){rdm=rdm+2;}
        sp=this.getSharedPreferences("AMMA", Context.MODE_PRIVATE);
        os=sp.getInt("key",0);
        if(os<=100)
        {
            to=Toast.makeText(GAME.this,"CONTROLL LEFT & RIGHT ALIEN BY TOUCHING LEFT&RIGHT PART OF SCREEN",Toast.LENGTH_LONG);
            to.show();
        }






    }
    @Override
    protected void onPause() {
        super.onPause();
        bk.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        bk.start();
    }





    @Override
    public boolean onTouch(View v, MotionEvent event) {
        s.start();
        x=event.getX();
        y=event.getY();
        return true;
    }


    public class Abi extends View {

            public Abi(GAME game) {
                super(game);
                ball = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
                bkg = BitmapFactory.decodeResource(getResources(), R.drawable.bkg);
                rng=BitmapFactory.decodeResource(getResources(),R.mipmap.tyu);
                tails=BitmapFactory.decodeResource(getResources(),R.mipmap.tails);
                gold=BitmapFactory.decodeResource(getResources(),R.mipmap.gold);
                p=new Paint();
                p.setColor(Color.WHITE);}


                @Override
                protected void onDraw (Canvas canvas){
                    super.onDraw(canvas);

                    h=canvas.getHeight();w=canvas.getWidth();

                    if(l==0)
                    {
                        b = w / 2 + 1;
                        a=w/3;
                        x=w/2;
                        l=1;
                        c[1]=c[5]=c[6]=0;
                        c[2]=c[3]=c[4]=c[7]=w/3;
                        e[1]=e[2]=e[3]=e[5]=w/2+1;
                        e[4]=e[6]=(5*w)/6+1;
                        t=(15*h)/1150;
                        for(i=1;i<=5;i++)
                        {g[i]=0;}


                    }
                    p.setTextSize((6 * w) / 150);

                    bkg=Bitmap.createScaledBitmap(bkg, (w), h, false);
                    ball=Bitmap.createScaledBitmap(ball,w/10,w/10,false);
                    rng=Bitmap.createScaledBitmap(rng,w/18,w/18,false);
                    tails=Bitmap.createScaledBitmap(tails,w/18,w/18,false);
                    gold=Bitmap.createScaledBitmap(gold,w/18,w/18,false);







                    r++;
                    canvas.drawBitmap(bkg,0,0,null);
                    if((x<w/2)&&(x>a+w/6)&&(a<w/3))
                    {a=a+w/6;x=w/2;}
                    else if((x<w/2)&&(x<a)&&(a>0))
                    {a=a-w/6;x=w/2;}
                    canvas.drawBitmap(ball, a, (3*h)/4, null);
                    if(x>w/2)
                    {if((x>b+w/6)&&(b<(5*w)/6)){b=b+w/6;x=w/2;}
                    else if ((x > (w / 2) + 1) && (x<b)){b=b-w/6;x=w/2;}
                    }
                    canvas.drawBitmap(ball,b,(3*h)/4,null);
                    x=w/2;
                    for(i=1;i<15;i++)
                    {if(c[i]<=0){d[i]=(5*t)/3;}
                    else if(c[i]>=w/3){d[i]=-(5*t)/3;}
                        if(e[i]<=w/2+1){f[i]=(5*t)/3;}
                        else if(e[i]>=((5*w))/6+1){f[i]=-(5*t)/3;}

                    }
                    for(i=1;i<=6;i++)
                    {
                        c[i]=c[i]+d[i];
                        e[i]=e[i]+f[i];
                    }
                    c[7]=c[7]+d[7];
                    if(rdm>6){
                        rdm=0;
                    }
                    po=-(h)+k;
                    canvas.drawBitmap(rng,c[(3+rdm)%6],po+h/4,null);CHECK1(c[(3 + rdm) % 6], po + h / 4);
                    if(g[1]==0) {
                        canvas.drawBitmap(gold, e[(1 + rdm) % 6], po + (3 * h) / 4, null);CHECKG2( e[(1 + rdm) % 6], po + (3 * h) / 4,1);
                    }
                    canvas.drawBitmap(tails,e[(2+rdm)%6],po+h/2,null);CHECK2(e[(2+rdm)%6],po+h/2);
                    po=-(2*h)+k;
                    canvas.drawBitmap(rng,c[(1+rdm)%6],po,null);CHECK1(c[(1+rdm)%6], po);
                    canvas.drawBitmap(tails,c[(2+rdm)%6],po+h/2,null);CHECK1(c[(2+rdm)%6], po + h / 2);
                    canvas.drawBitmap(rng,e[(1+rdm)%6],po+h/3,null);CHECK2(e[(1+rdm)%6], po + h / 3);

                    po=-(3*h)+k;
                    if(g[2]==0)
                    {
                        canvas.drawBitmap(gold,c[(3+rdm)%6],po+h/2+h/6,null);CHECKG1(c[(3+rdm)%6],po+h/2+h/6,2);
                    }
                                                                         canvas.drawBitmap(tails, e[(3+rdm)%6], po, null);CHECK2(e[(3+rdm)%6], po);
                    canvas.drawBitmap(rng,c[(5+rdm)%6],po,null);CHECK1(c[(5+rdm)%6], po);
                                                                        canvas.drawBitmap(rng,e[(5+rdm)%6],po+(3*h)/4,null);CHECK2(e[(5+rdm)%6], po + (3 * h) / 4);
                    canvas.drawBitmap(tails, c[(7 + rdm) % 6], po + (2* h) / 4, null);CHECK1(c[(7 + rdm) % 6], po + (2 * h) / 4);
                    po=-(4*h)+k;
                    canvas.drawBitmap(rng, c[(1 + rdm) % 6], po + h / 3, null);
                    if(g[3]==0)
                    {
                        canvas.drawBitmap(gold,e[(1+rdm)%6],po+h/2,null);CHECKG2(e[(1+rdm)%6],po+h/2,3);
                    }
                    CHECK1( c[(1 + rdm) % 6], po + h / 3);
                    canvas.drawBitmap(tails, e[(2+rdm)%6], po + h / 10, null);CHECK2(e[(2+rdm)%6], po + h / 10);
                    po=-(5*h)+k;
                    if(g[4]==0){
                        canvas.drawBitmap(gold, c[(1 + rdm) % 6],po,null);CHECKG1(c[(1 + rdm) % 6],po,4);
                    }

                    canvas.drawBitmap(rng, c[(2+rdm)%6], po + h / 2, null);CHECK1(c[(2+rdm)%6], po + h / 2);
                    canvas.drawBitmap(tails,e[(1+rdm)%6],po+h/2,null);CHECK2(e[(1+rdm)%6], po + h / 2);
                    canvas.drawBitmap(rng,e[(3+rdm)%6],po,null);CHECK2(e[(3+rdm)%6], po);
                    po=-(6*h)+k;
                    if(g[5]==0)
                    {
                        canvas.drawBitmap(gold,c[(2+rdm)%6],po+(3*h)/4,null);CHECKG1(c[(2+rdm)%6],po+(3*h)/4,5);
                    }
                    canvas.drawBitmap(rng, e[(2+rdm)%6], po + h / 2, null);CHECK2(e[(2+rdm)%6], po + h / 2);
                    canvas.drawBitmap(tails,e[(1+rdm)%6],po,null);CHECK2(e[(1+rdm)%6], po );
                    canvas.drawBitmap(tails, c[(2+rdm)%6], po + h / 2, null);CHECK1(c[(2+rdm)%6], po + h / 2);



                    if(k>=(7*h)){
                        k=0;t=t+(15*h)/2000;
                        rdm=rdm+1;
                        mul=mul*2;
                        for(i=1;i<=5;i++)
                        {g[i]=0;}

                    }
                    else{k=k+t;}



                    canvas.drawText(""+r,0,h/8,p);
                    invalidate();


                }




    }public void CHECK1(float ix, float iy) {
        if(((a+w/80<=ix+w/18)&&(a+w/80>=ix)&&((3*h)/4>=iy)&&((3*h)/4<=iy+w/18))||((a+w/10-w/80<=ix+w/18)&&(a+w/10-w/80>=ix)&&((3*h)/4>=iy)&&((3*h)/4<=iy+w/18))||((a+w/80<=ix+w/18)&&(a+w/80>=ix)&&((3*h)/4+w/20>=iy)&&((3*h)/4+w/20<=iy+w/18))||((a+w/11-w/80<=ix+w/18)&&(a+w/11-w/80>=ix)&&((3*h)/4+w/20>=iy)&&((3*h)/4+w/20<=iy+w/18))){
setContentView(R.layout.activity_main);
            rdm=rdm+1;
            SharedPreferences.Editor edr=rm.edit();
            edr.putInt("ky", rdm);
            edr.commit();
            bk.stop();
            pot.start();
            TextView tv1,tv2,tv3;
            tv3=(TextView)findViewById(R.id.gold);
            tv1=(TextView)findViewById(R.id.score);
            tv2=(TextView)findViewById(R.id.hscore);
            tv1.setText("YOUR SCORE : " + r);
            tv1.setTextColor(Color.WHITE);
            tv3.setText(": " + tg);
            tv3.setTextColor(Color.WHITE);

            if(r>os)
            {
                SharedPreferences.Editor edtor=sp.edit();
                edtor.putInt("key",r);
                edtor.commit();
            }
            os=sp.getInt("key",0);
            tv2.setText("HIGH SCORE : "+os);
            tv2.setTextColor(Color.GREEN);
        }

        }
    public void CHECK2(float ix, float iy) {
        if(((b+w/80<=ix+w/18)&&(b+w/80>=ix)&&((3*h)/4>=iy)&&((3*h)/4<=iy+w/18))||((b+w/10-w/80<=ix+w/18)&&(b+w/10-w/80>=ix)&&((3*h)/4>=iy)&&((3*h)/4<=iy+w/18))||((b+w/80<=ix+w/18)&&(b+w/80>=ix)&&((3*h)/4+w/20>=iy)&&((3*h)/4+w/20<=iy+w/18))||((b+w/11-w/80<=ix+w/18)&&(b+w/11-w/80>=ix)&&((3*h)/4+w/20>=iy)&&((3*h)/4+w/20<=iy+w/18))){
            setContentView(R.layout.activity_main);
            rdm=rdm+1;
            SharedPreferences.Editor edr=rm.edit();
            edr.putInt("ky", rdm);
            edr.commit();
            bk.stop();
            pot.start();
            TextView tv1,tv2,tv3;
            tv1=(TextView)findViewById(R.id.score);
            tv2=(TextView)findViewById(R.id.hscore);
            tv3=(TextView)findViewById(R.id.gold);
            tv1.setText("YOUR SCORE : " + r);
            tv1.setTextColor(Color.WHITE);
            tv3.setText(": " + tg);
            tv3.setTextColor(Color.WHITE);

            if(r>os)
            {
                SharedPreferences.Editor edtor=sp.edit();
                edtor.putInt("key",r);
                edtor.commit();
            }
            os=sp.getInt("key",0);
            tv2.setText("HIGH SCORE : "+os);
            tv2.setTextColor(Color.GREEN);
        }

    }
    public void CHECKG1(float ix,float iy,int gc){
        if(((a+w/80<=ix+w/18)&&(a+w/80>=ix)&&((3*h)/4>=iy)&&((3*h)/4<=iy+w/18))||((a+w/10-w/80<=ix+w/18)&&(a+w/10-w/80>=ix)&&((3*h)/4>=iy)&&((3*h)/4<=iy+w/18))||((a+w/80<=ix+w/18)&&(a+w/80>=ix)&&((3*h)/4+w/20>=iy)&&((3*h)/4+w/20<=iy+w/18))||((a+w/11-w/80<=ix+w/18)&&(a+w/11-w/80>=ix)&&((3*h)/4+w/20>=iy)&&((3*h)/4+w/20<=iy+w/18))){
            gld.start();
            g[gc]=1;
            lg=lg+1;
            tg=lg+rg;
            r=r+(50*mul);
        }

    }
    public void CHECKG2(float ix,float iy,int gc){
        if(((b+w/80<=ix+w/18)&&(b+w/80>=ix)&&((3*h)/4>=iy)&&((3*h)/4<=iy+w/18))||((b+w/10-w/80<=ix+w/18)&&(b+w/10-w/80>=ix)&&((3*h)/4>=iy)&&((3*h)/4<=iy+w/18))||((b+w/80<=ix+w/18)&&(b+w/80>=ix)&&((3*h)/4+w/20>=iy)&&((3*h)/4+w/20<=iy+w/18))||((b+w/11-w/80<=ix+w/18)&&(b+w/11-w/80>=ix)&&((3*h)/4+w/20>=iy)&&((3*h)/4+w/20<=iy+w/18))){
            gld.start();
          g[gc]=1;
            rg=rg+1;
            tg=lg+rg;
            r=r+(50*mul);
        }

    }


    }

