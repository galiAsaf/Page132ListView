package com.gali.p.page132listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.graphics.Color.CYAN;
import static android.graphics.Color.YELLOW;

public class MainActivity extends AppCompatActivity {

    ArrayList<Song> arySong = new ArrayList<>();
    ListView latView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        latView1 = findViewById(R.id.list1);

        getSongData();

        latView1 = (ListView) findViewById(R.id.list1);

        SongAdapter sa = new SongAdapter(this, R.layout.song, arySong);
        latView1.setAdapter(sa);

        latView1.setOnItemClickListener(lst1Listener);
        latView1.setOnItemLongClickListener(lst1LongClick);
    }

    public void getSongData() {
        Song s;
        for (int i = 1; i <= 10; i++) {
            s = new Song("img1.jpg", "song name" + i, "singer name" + i, i);
            arySong.add(s);
        }
    }


    //********************************************************************************************************************
    public class SongAdapter extends ArrayAdapter<Song> {


        private Context ctx;
        private int songResourceId;
        private List<Song> data;

        public SongAdapter(Context context, int resource, List<Song> data) {
            super(context, resource);
            this.ctx = (MainActivity) context;
            this.songResourceId = resource;
            this.data = data;
        }

        public int getCount() {
            return data.size();
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater li = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View v = li.inflate(this.songResourceId, null);

            Song s = this.data.get(position);
            TextView tv1 = v.findViewById(R.id.songName);
            tv1.setText(s.getSongName());
            TextView tv2 = v.findViewById(R.id.singerName);
            tv2.setText(s.getSingerName());
            TextView tv3 = v.findViewById(R.id.time);
            tv3.setText(String.valueOf(s.getTime()));

            return v;
        }


    }


    private AdapterView.OnItemClickListener lst1Listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this, arySong.get(position).toString(), Toast.LENGTH_LONG).show();
        }
    };
    private AdapterView.OnItemLongClickListener lst1LongClick = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            final String[] shareAry = {"Facebook", "Twitter", "Whatsapp"};
            AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
            adb.setTitle("Share in...");
            ArrayAdapter<String> arySharing = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, shareAry);

            adb.setAdapter(arySharing, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this, shareAry[i], Toast.LENGTH_SHORT).show();
                }
            });

            AlertDialog ad = adb.create();
            ad.getListView().setBackgroundColor(CYAN);
            ad.show();
            return true;
        }

    };
}



















