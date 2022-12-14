package com.example.mynotesapp;

import android.annotation.SuppressLint;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.util.Random;

@RequiresApi(api = Build.VERSION_CODES.O)
public class Note {

    private static final Random random = new Random();
    private static Note[] notes;
    private String title;
    private String description;
    private LocalDateTime dateOfCreation;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public static Note[] getNotes() {
        return notes;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public Note(String title, String description, LocalDateTime dateOfCreation) {
        this.title = title;
        this.description = description;
        this.dateOfCreation = dateOfCreation;
    }

    // инициализатор массива заметок
    static {
        notes = new Note[10];
        for (int i=0; i< notes.length; i++) {
            notes[i] = Note.createNote(i);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("DefaultLocale")
    public static Note createNote(int index) {
        String title = String.format("Заметка %d", index);
        String description = String.format("Описание заметки %d", index);
        LocalDateTime dateOfCreation = LocalDateTime.now().plusDays(-random.nextInt(5));
        return new Note(title, description, dateOfCreation);
    }
}
