package com.example.speakup;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    MainTable mainTable;
    List<MainTable> mainTableEntries;
    RecyclerView alphaRV;
    AlphaAdapter alphaAdapter;
    ImageView settingButton;
    RelativeLayout home_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        alphaRV = findViewById(R.id.alphaRV);
        settingButton = findViewById(R.id.settingButton);

        GlobalVariables.getInstance().setMainActivity(this);
        mainTable = new MainTable();
        initDB();
        mainTableEntries = new ArrayList<>();
        home_main = findViewById(R.id.home_main);

        /*
         * Wait Until DB Completely Ready
         * */
        GlobalVariables.getHandlerUI().postDelayed(() ->
        {
            home_main.setBackgroundColor(GlobalVariables.getInstance().getGlobalThemeColor());
            mainTableEntries = mainTable.getAlphaRecords();
            alphaAdapter = new AlphaAdapter(getApplicationContext(), mainTableEntries);
            alphaRV.setAdapter(alphaAdapter);
            alphaRV.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        }, 200);

        settingButton.setOnClickListener(v ->
        {
            Intent intent = new Intent(this, AppSettings.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }

    /*
     * Adding All Into MainDB
     * Params: alphaWord, alphaSentence and alphaIcon
     * */
    private void initDB() {
        mainTable.insertRecordsAlphabets("apple", "I like to eat an apple", "apple");
        mainTable.insertRecordsAlphabets("bird", "This is a bird", "bird");
        mainTable.insertRecordsAlphabets("cat", "Cat like to drink milk", "cat");
        mainTable.insertRecordsAlphabets("dog", "I love dog", "dog");
        mainTable.insertRecordsAlphabets("elephant", "This elephant is big", "elephant");
        mainTable.insertRecordsAlphabets("fish", "Fish lives in water", "fish");
        mainTable.insertRecordsAlphabets("goat", "Goat has four legs", "goat");
        mainTable.insertRecordsAlphabets("horse", "Horse has a hairy tail", "horse");
        mainTable.insertRecordsAlphabets("ice cream", "I love ice cream", "ice");
        mainTable.insertRecordsAlphabets("jam", "This is homemade jam", "jam");
        mainTable.insertRecordsAlphabets("kite", "He flew a kite", "kite");
        mainTable.insertRecordsAlphabets("lion", "Lion is a wild animal", "lion");
        mainTable.insertRecordsAlphabets("monkey", "The monkey was swinging in the tree", "monkey");
        mainTable.insertRecordsAlphabets("nose", "I want to scratch my nose", "nose");
        mainTable.insertRecordsAlphabets("orange", "I want some orange juice", "oranges");
        mainTable.insertRecordsAlphabets("penguin", "Penguin likes to eat fish", "penguin");
        mainTable.insertRecordsAlphabets("queen", "The queen lives in castle", "queen");
        mainTable.insertRecordsAlphabets("rabbit", "A rabbit is a small animal with long ears", "rabbit");
        mainTable.insertRecordsAlphabets("sun", "Sun is a star", "sun");
        mainTable.insertRecordsAlphabets("train", "The train was late", "train");
        mainTable.insertRecordsAlphabets("umbrella", "It's my umbrella", "umbrella");
        mainTable.insertRecordsAlphabets("violin", "She likes to play violin", "violin");
        mainTable.insertRecordsAlphabets("water", "We use water for drinking", "water");
        mainTable.insertRecordsAlphabets("x-ray", "Tim went to the x-ray room", "xray");
        mainTable.insertRecordsAlphabets("yoyo", "Tim likes to play yoyo", "yoyo");
        mainTable.insertRecordsAlphabets("zebra", "Zebra is a beautiful animal", "zebra");
    }
}