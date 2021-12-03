package com.nsg.glo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    private ListView mListView;
    // int [] images = {R.drawable.a , R.drawable.b , R.drawable.c};

    String [] names = {"Name-1" , "Name-2" , "Name-3" , "Name-4", "Name-5",
                       "Name-6", "Name-7", "Name-8", "Name-9", "Name-10"};

    String [] uris = {"https://www.naver.com","https://www.daum.net","https://www.nexon.com", "url-4"
                     , "url-5", "url-6", "url-7", "url-8", "url-9", "url-10"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mListView = findViewById(R.id.listview);

        MyAdapter adapter = new MyAdapter();
        mListView.setAdapter(adapter);

    }
    class MyAdapter extends BaseAdapter{

//        @Override
//        public int getCount() {
//            return images.length;
//        }

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.card_listview,parent , false);
            TextView textView = convertView.findViewById(R.id.textView4);
            //ImageView imageView = convertView.findViewById(R.id.imageview);
            textView.setText(names[position]);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browerIntent = new Intent(Intent.ACTION_VIEW,Uri.parse(uris[position]));
                    startActivity(browerIntent);
                }
            });
            //imageView.setImageResource(images[position]);
            return  convertView;
        }
    }
}