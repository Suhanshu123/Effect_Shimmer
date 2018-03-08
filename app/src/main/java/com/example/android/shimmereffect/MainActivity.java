package com.example.android.shimmereffect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

public class MainActivity extends AppCompatActivity {

    Shimmer shimmer;
    Button btn;
    ShimmerTextView shimmerTextView;
    boolean shim_visibility=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shimmerTextView=findViewById(R.id.shimmer_tv);
        btn=findViewById(R.id.button);
        shimmer=new Shimmer()
                .setDirection(Shimmer.ANIMATION_DIRECTION_LTR)
                .setDuration(500)
                .setStartDelay(300);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shim_visibility){
                    shimmer.start(shimmerTextView);
                    btn.setText("Stop");
                    shim_visibility=false;
                }
                else
                {
                    shimmer.cancel();
                    btn.setText("Start");
                    shim_visibility=true;
                }

            }
        });
    }
}
