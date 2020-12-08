package com.gali.p.page132listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Song> arySong = new ArrayList<>();
    ListView latView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        latView1= findViewById(R.id.list1);

        getSongData();

        latView1 = (ListView) findViewById(R.id.list1);

        SongAdapter sa= new SongAdapter(this, R.layout.song, arySong);
        latView1.setAdapter(sa);
    }

    public void getSongData(){
        Song s;
        for (int i =1; i<= 10; i++)
        {
            s=new Song("img1.jpg", "song name"+i, "singer name"+i, i);
            arySong.add(s);
        }
    }

    //********************************************************************************************************************

    public class SongAdapter extends ArrayAdapter<Song>
    {
        private Context ctx;
        private int songResourceId;
        private List<Song> data;

        public SongAdapter(Context context, int resource, List<Song> data) {
            super(context, resource);
            this.ctx = (MainActivity) context;
            this.songResourceId = resource;
            this.data = data;
        }

        public int getCount(){
            return data.size();
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater li = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View v = li.inflate(this.songResourceId,null);

            Song s = this.data.get(position);
            TextView tv1= v.findViewById(R.id.songName);
            tv1.setText(s.getSongName());
            TextView tv2= v.findViewById(R.id.singerName);
            tv2.setText(s.getSingerName());
            TextView tv3= v.findViewById(R.id.time);
            tv3.setText(String.valueOf(s.getTime()));

            return v;
        }
    }

}
