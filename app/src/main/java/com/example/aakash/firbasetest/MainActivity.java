package com.example.aakash.firbasetest;

import android.support.annotation.NonNull;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    /*EditText editText;
    Button btn1;
    String text;
    TextView txtview;
    Firebase myfirebase;
    ArrayList<String> arrayList = new ArrayList<>();
    ListView listView;
    String cde;*/

    EditText id,pass;
    Button btnsub;
    String idtxt,passtxt;
    FirebaseAuth myfirebaseauth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myfirebaseauth = FirebaseAuth.getInstance();

      /* editText = (EditText)findViewById(R.id.abc);
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


             *//* *//**//* while(nchid.getKey().toString() != null)
               {*//**//*
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
                   });*//*
               *//*}*//*
               *
               *













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
*/
        Firebase.setAndroidContext(getApplicationContext());



        id = (EditText)findViewById(R.id.email);
        pass = (EditText)findViewById(R.id.pass);
        btnsub = (Button)findViewById(R.id.btn);




        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idtxt = id.getText().toString();
                passtxt = pass.getText().toString();
                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();

                myfirebaseauth.createUserWithEmailAndPassword(idtxt,passtxt)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();                        } else {
                                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });


            }
        });





    }
}
