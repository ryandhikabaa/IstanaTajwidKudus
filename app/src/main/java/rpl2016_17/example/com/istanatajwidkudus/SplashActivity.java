package rpl2016_17.example.com.istanatajwidkudus;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    ImageView icon;
    ImageView title;
    Animation frombottom, fromtop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        icon = (ImageView)findViewById(R.id.icon);
        title = (ImageView)findViewById(R.id.title);

        frombottom = AnimationUtils.loadAnimation(this,R.anim.frombottom);
        fromtop = AnimationUtils.loadAnimation(this,R.anim.fromtop);

        title.setAnimation(frombottom);
        icon.setAnimation(fromtop);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),home.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}
