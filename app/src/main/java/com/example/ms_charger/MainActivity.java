package com.example.ms_charger;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player;

    SeekBar sekbr;
    ImageView playpause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player = MediaPlayer.create(getApplicationContext(),R.raw.main);

        sekbr = findViewById(R.id.seekBar);
        sekbr.setMax(player.getDuration());
        sekbr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                player.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                sekbr.setProgress(player.getCurrentPosition());
            }
        },0,10);

        playpause = findViewById(R.id.playIcon);


    }

    public void previousTrack(View view) {
    }

    public void playTrack(View view) {
        if (player.isPlaying()){
            player.pause();
            playpause.setImageResource(R.drawable.play_24);

        } else{
            player.start();
            playpause.setImageResource(R.drawable.pause_24);

        }
    }

    public void nextTrack(View view) {
    }
}