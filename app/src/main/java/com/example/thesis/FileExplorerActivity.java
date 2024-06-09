package com.example.thesis;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileExplorerActivity extends AppCompatActivity {
    private List<String> fileList = new ArrayList<>();
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private File currentDirectory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_explorer);

        listView = findViewById(R.id.listView);
        Button backButton = findViewById(R.id.backButton);

        // Set adapter for ListView
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, fileList);
        listView.setAdapter(adapter);

        // List files in external storage directory
        currentDirectory = Environment.getExternalStorageDirectory();
        listFiles(currentDirectory);

        // Set item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Navigate to the selected directory or show a toast if it's a file
                String selectedFile = fileList.get(position);
                String path = currentDirectory.getAbsolutePath() + "/" + selectedFile;
                File file = new File(path);
                if (file.isDirectory()) {
                    currentDirectory = file; // Update current directory
                    listFiles(currentDirectory); // Open directory

                } else {
                    Toast.makeText(FileExplorerActivity.this, "File: " + selectedFile, Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set click listener for back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the parent directory
                if (currentDirectory.getParentFile() != null) {
                    currentDirectory = currentDirectory.getParentFile();
                    listFiles(currentDirectory);
                }
            }
        });
    }

    private void listFiles(File directory) {
        fileList.clear();
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory() || file.isHidden()) {
                    fileList.add(file.getName());
                }
            }
            adapter.notifyDataSetChanged();
        }
    }
}