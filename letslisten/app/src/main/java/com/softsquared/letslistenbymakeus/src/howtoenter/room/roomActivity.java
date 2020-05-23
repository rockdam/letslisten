package com.softsquared.letslistenbymakeus.src.howtoenter.room;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.util.Base64;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;

public class roomActivity extends AppCompatActivity {
    private Socket mSocket;
    private String mData;
    private byte[] mBytes;
    private boolean isfirst = true;
    private boolean isFirstMusic =true;
    Handler mHandler;
    private Runnable mUpdate;
    private MediaPlayer mStartMediaPlayer = new MediaPlayer();
    private MediaPlayer mSetMediaPlayer = new MediaPlayer();
    int mDuration;// 재생시간
    private String mBuffer = "";
    int count=0;
    private void playMp3(byte[] mp3SoundByteArray) {
        try {
            // create temp file that will hold byte array
            File tempMp3 = File.createTempFile("kurchina", "mp3", getCacheDir());
            tempMp3.deleteOnExit();
            FileOutputStream fos = new FileOutputStream(tempMp3);
            fos.write(mp3SoundByteArray);
            fos.close();

            // resetting mediaplayer instance to evade problems
            mStartMediaPlayer.reset();

            // In case you run into issues with threading consider new instance like:
            // MediaPlayer mediaPlayer = new MediaPlayer();

            // Tried passing path directly, but kept getting
            // "Prepare failed.: status=0x1"
            // so using file descriptor instead
            FileInputStream fis = new FileInputStream(tempMp3);
            mStartMediaPlayer.setDataSource(fis.getFD());
            mStartMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mStartMediaPlayer.prepare();

            mStartMediaPlayer.start();



            mDuration = mStartMediaPlayer.getDuration();

            Log.e("시간", "" + mDuration);
            mSocket.emit("count",mDuration);
        } catch (IOException ex) {
            String s = ex.toString();
            ex.printStackTrace();
        }

        //실행 시간 만큼 쓰레드를 만들어서 보낸다면? emit을 .

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (isfirst) {
            try {
                mSocket = IO.socket("http://10.88.76.61");
                mSocket.connect();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

            isfirst = false;

        }
        mSocket.on("chunk", new Emitter.Listener() {

            @Override
            public void call(Object... args) {


                mData = (String) args[0];
//                mBuffer+=mData;
                if (mData.length() != 0) {
                    Log.e("청크 확인", "" + mData);
                    mBytes = Base64.decode(mData, Base64.DEFAULT);
//                    audioSynth = new AudioSynthesisTask(mData);
//
//                    audioSynth.execute();

                    playMp3(mBytes);// byte 넘겨 받아서 재생하기 .
//



                } else {


                }


            }

        }); //서버에서 base 64 보내면 해독하기.


        mStartMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mStartMediaPlayer.start();
            }
        });

    }






    @Override
    protected void onRestart() {
        super.onRestart();


    }

    @Override
    protected void onPause() {
        super.onPause();
        mStartMediaPlayer.stop();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mStartMediaPlayer.stop();
    }
}
