package com.gali.p.page132listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Song> arySong = new ArrayList<>();
    ListView latView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSongData();

        latView1= findViewById(R.id.list1);

        latView1.setAdapter(SongAdapter);
    }

    public void getSongData(){
        Song s;
        for (int i =1; i<= 10; i++)
        {
            s=new Song("img1.png", "song name"+i, "singer name"+i, 6);
            arySong.add(s);
        }
    }

    //********************************************************************************************************************

    public class SongAdapter extends ArrayAdapter<Song>
    {

    }

}
