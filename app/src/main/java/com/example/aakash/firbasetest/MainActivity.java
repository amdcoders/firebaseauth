package com.example.aakash.firbasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText editText;
    Button btn1;
    String text;
    TextView txtview;
    Firebase myfirebase;
    ArrayList<String> arrayList = new ArrayList<>();
    ListView listView;
    String cde;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       editText = (EditText)findViewById(R.id.abc);
       btn1 = (Button) findViewById(R.id.btn);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);


       listView = (ListView)findViewById(R.id.lstview);
       listView.setAdapter(arrayAdapter);


        Firebase.setAndroidContext(getApplicationContext());
        myfirebase = new Firebase("https://fir-teset-efcae.firebaseio.com");
       btn1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               arrayList.clear();
               text = editText.getText().toString();
               Firebase nchid = myfirebase.child("cname");
               //nchid.setValue(text);
               nchid.push().setValue(text);
               Toast.makeText(MainActivity.this,"updated " +text,Toast.LENGTH_SHORT).show();
               arrayList.clear();


             /* *//* while(nchid.getKey().toString() != null)
               {*//*
                   nchid.addValueEventListener(new ValueEventListener() {
                       @Override
                       public void onDataChange(DataSnapshot dataSnapshot) {
                           String abc = dataSnapshot.getValue(String.class);
                           //arrayList.add(abc);
                           Toast.makeText(MainActivity.this,"Count" +abc,Toast.LENGTH_SHORT).show();
                       }

                       @Override
                       public void onCancelled(FirebaseError firebaseError) {

                       }
                   });*/
               /*}*/












               nchid.addChildEventListener(new ChildEventListener() {
                   @Override
                   public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                       String abc = dataSnapshot.getValue(String.class);
                       arrayList.add(abc);
                       Toast.makeText(MainActivity.this,"Count" +arrayList.size(),Toast.LENGTH_SHORT).show();
                       arrayAdapter.notifyDataSetChanged();

                   }

                   @Override
                   public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                       arrayAdapter.notifyDataSetChanged();
                   }

                   @Override
                   public void onChildRemoved(DataSnapshot dataSnapshot) {

                   }

                   @Override
                   public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                   }

                   @Override
                   public void onCancelled(FirebaseError firebaseError) {

                   }
               });






           }
       });


    }
}
