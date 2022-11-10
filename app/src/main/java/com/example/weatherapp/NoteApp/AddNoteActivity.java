package com.example.weatherapp.NoteApp;

import java.lang.*;

import androidx.appcompat.app.AppCompatActivity;

import io.realm.DynamicRealm;
import io.realm.Realm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import io.realm.RealmConfiguration;

import com.example.weatherapp.R;
import com.google.android.material.button.MaterialButton;

public class AddNoteActivity extends AppCompatActivity {

    EditText titleInput;
    EditText descriptionInput;
    MaterialButton saveBtn;

    Boolean isUpdate = false;
    String id = null;
    String prevId = null;

    RealmConfiguration config = new RealmConfiguration.Builder().name("Note.realm").deleteRealmIfMigrationNeeded().schemaVersion(1).build();


//    Realm realm = Realm.getDefaultInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createnote);
        titleInput = findViewById(R.id.titleinput);
        descriptionInput = findViewById(R.id.descriptioninput);
        saveBtn = findViewById(R.id.savebtn);

        id = getIntent().getStringExtra("ID");
        prevId = id;
        if(id != null){
            isUpdate = true;
            Note currentNote = Realm.getInstance(config).where(Note.class).equalTo("id", id).findFirst();
            if(currentNote != null){
                titleInput.setText(currentNote.getTitle().toString());
                descriptionInput.setText(currentNote.getDescription().toString());
            }
        }


        Realm.init(getApplicationContext());
        saveBtn.setOnClickListener(v -> {
             if(isUpdate){
                 updateNote();
                 Realm realm = Realm.getInstance(config);
                 Note currentNote = Realm.getInstance(config).where(Note.class).equalTo("id", prevId).findFirst();
                 if(currentNote != null){
                     realm.beginTransaction();
                     currentNote.deleteFromRealm();
                     realm.commitTransaction();
                 }

             }else{
                 saveNote();
             }

        });

    }


    private void updateNote(){
        Realm realm = Realm.getInstance(config);
        String title = titleInput.getText().toString();
        String description = descriptionInput.getText().toString();
        long createdTime = System.currentTimeMillis();
        realm.beginTransaction();
        Note note = realm.createObject(Note.class);
//        noteManager.addNote(note);
        note.setId(id);
        note.setTitle(title);
        note.setDescription(description);
        note.setCreatedTime(createdTime);
        realm.commitTransaction();
        realm.close();
        finish();
    }
    private void saveNote(){
//        NoteRealmManager noteManager = new NoteRealmManager();
        Realm realm = Realm.getInstance(config);
        String title = titleInput.getText().toString();
        String description = descriptionInput.getText().toString();
        long createdTime = System.currentTimeMillis();
        realm.beginTransaction();
        Note note = realm.createObject(Note.class);
//        noteManager.addNote(note);
        note.setId(String.valueOf(System.currentTimeMillis()));
        note.setTitle(title);
        note.setDescription(description);
        note.setCreatedTime(createdTime);
        realm.commitTransaction();
        realm.close();
        Toast.makeText(getApplicationContext(),"Note saved",Toast.LENGTH_SHORT).show();
        finish();
    };

}