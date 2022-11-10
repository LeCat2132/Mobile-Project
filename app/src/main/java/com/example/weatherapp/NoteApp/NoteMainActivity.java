package com.example.weatherapp.NoteApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.Sort;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

import com.example.weatherapp.R;

public class NoteMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_activity_main);
        ImageButton addNoteBtn = findViewById(R.id.addnewnotebtn);


        addNoteBtn.setOnClickListener(v -> startActivity(new Intent(NoteMainActivity.this, AddNoteActivity.class)));
        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration.Builder().name("Note.realm").deleteRealmIfMigrationNeeded().schemaVersion(1).build();

        Realm realm = Realm.getInstance(config);


        RealmResults<Note> notesList = realm.where(Note.class).sort("createdTime", Sort.DESCENDING).findAll();


        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter = new MyAdapter(getApplicationContext(), notesList);
        recyclerView.setAdapter(myAdapter);

        notesList.addChangeListener(notes -> myAdapter.notifyDataSetChanged());

    }
}