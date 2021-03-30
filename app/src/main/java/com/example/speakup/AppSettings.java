package com.example.speakup;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.res.ResourcesCompat;

public class AppSettings extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private SwitchCompat smallSizeSC, mediumSizeSC, largeSizeSC;
    private TextView textSizeNote, smallTV, mediumTV, largeTV;

    private SwitchCompat fontArialSC, fontComiSansSC, fontHelveticaSC, fontTahomaSC, fontTrebuchetSC, fontVerdanaSC;
    private TextView textFontNote, arialTV, comisansTV, helveticaTV, tahomaTV, trebuchetTV, verdanaTV;

    private SwitchCompat blueThemeSC, darkYellowThemeSC, greenThemeSC;
    private TextView textThemeNote, blueThemeTV, darkYellowThemeTV, greenThemeTV;

    private RelativeLayout mainViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_settings);

        mainViews = findViewById(R.id.mainViews);
        //Font Size Component
        smallSizeSC = findViewById(R.id.smallSizeSC);
        mediumSizeSC = findViewById(R.id.mediumSizeSC);
        largeSizeSC = findViewById(R.id.largeSizeSC);
        textSizeNote = findViewById(R.id.textSizeNote);
        smallTV = findViewById(R.id.smallTV);
        mediumTV = findViewById(R.id.mediumTV);
        largeTV = findViewById(R.id.largeTV);
        smallSizeSC.setOnCheckedChangeListener(this);
        mediumSizeSC.setOnCheckedChangeListener(this);
        largeSizeSC.setOnCheckedChangeListener(this);
        //Font Family Component
        fontArialSC = findViewById(R.id.fontArialSC);
        fontComiSansSC = findViewById(R.id.fontComiSansSC);
        fontHelveticaSC = findViewById(R.id.fontHelveticaSC);
        fontTahomaSC = findViewById(R.id.fontTahomaSC);
        fontTrebuchetSC = findViewById(R.id.fontTrebuchetSC);
        fontVerdanaSC = findViewById(R.id.fontVerdanaSC);
        arialTV = findViewById(R.id.arialTV);
        comisansTV = findViewById(R.id.comisansTV);
        helveticaTV = findViewById(R.id.helveticaTV);
        tahomaTV = findViewById(R.id.tahomaTV);
        trebuchetTV = findViewById(R.id.trebuchetTV);
        verdanaTV = findViewById(R.id.verdanaTV);
        textFontNote = findViewById(R.id.textFontNote);
        fontArialSC.setOnCheckedChangeListener(this);
        fontComiSansSC.setOnCheckedChangeListener(this);
        fontHelveticaSC.setOnCheckedChangeListener(this);
        fontTahomaSC.setOnCheckedChangeListener(this);
        fontTrebuchetSC.setOnCheckedChangeListener(this);
        fontVerdanaSC.setOnCheckedChangeListener(this);
        //App Theme Component
        blueThemeSC = findViewById(R.id.blueThemeSC);
        darkYellowThemeSC = findViewById(R.id.darkYellowThemeSC);
        greenThemeSC = findViewById(R.id.greenThemeSC);
        textThemeNote = findViewById(R.id.textThemeNote);
        blueThemeTV = findViewById(R.id.blueThemeTV);
        darkYellowThemeTV = findViewById(R.id.darkYellowThemeTV);
        greenThemeTV = findViewById(R.id.greenThemeTV);
        blueThemeSC.setOnCheckedChangeListener(this);
        darkYellowThemeSC.setOnCheckedChangeListener(this);
        greenThemeSC.setOnCheckedChangeListener(this);

        performDefaultSettings();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            /*
             * Begin Font Size Configurations
             * */
            case R.id.smallSizeSC:
                if (isChecked) {
                    mediumSizeSC.setChecked(false);
                    largeSizeSC.setChecked(false);
                    changeTextSize(14);
                    GlobalVariables.getInstance().setFontSizeSwitch(buttonView.getId());
                } else if (!mediumSizeSC.isChecked() & !largeSizeSC.isChecked())
                    smallSizeSC.setChecked(true);
                break;
            case R.id.mediumSizeSC:
                if (isChecked) {
                    smallSizeSC.setChecked(false);
                    largeSizeSC.setChecked(false);
                    changeTextSize(15);
                    GlobalVariables.getInstance().setFontSizeSwitch(buttonView.getId());
                } else if (!smallSizeSC.isChecked() & !largeSizeSC.isChecked())
                    mediumSizeSC.setChecked(true);
                break;
            case R.id.largeSizeSC:
                if (isChecked) {
                    smallSizeSC.setChecked(false);
                    mediumSizeSC.setChecked(false);
                    changeTextSize(16);
                    GlobalVariables.getInstance().setFontSizeSwitch(buttonView.getId());
                } else if (!smallSizeSC.isChecked() & !mediumSizeSC.isChecked())
                    largeSizeSC.setChecked(true);
                break;

            /*
             * Begin Font Family Configurations
             * */
            case R.id.fontArialSC:
                if (isChecked) {
                    fontComiSansSC.setChecked(false);
                    fontHelveticaSC.setChecked(false);
                    fontTahomaSC.setChecked(false);
                    fontTrebuchetSC.setChecked(false);
                    fontVerdanaSC.setChecked(false);
                    changeFontFamily(this, R.font.arial);
                    GlobalVariables.getInstance().setFontFamilySwitch(buttonView.getId());
                } else if (!fontComiSansSC.isChecked() & !fontHelveticaSC.isChecked() & !fontTahomaSC.isChecked() &
                        !fontTrebuchetSC.isChecked() & !fontVerdanaSC.isChecked()) {
                    fontArialSC.setChecked(true);
                }
                break;
            case R.id.fontComiSansSC:
                if (isChecked) {
                    fontArialSC.setChecked(false);
                    fontHelveticaSC.setChecked(false);
                    fontTahomaSC.setChecked(false);
                    fontTrebuchetSC.setChecked(false);
                    fontVerdanaSC.setChecked(false);
                    changeFontFamily(this, R.font.comicsans);
                    GlobalVariables.getInstance().setFontFamilySwitch(buttonView.getId());
                } else if (!fontArialSC.isChecked() & !fontHelveticaSC.isChecked() & !fontTahomaSC.isChecked() &
                        !fontTrebuchetSC.isChecked() & !fontVerdanaSC.isChecked()) {
                    fontComiSansSC.setChecked(true);
                }
                break;
            case R.id.fontHelveticaSC:
                if (isChecked) {
                    fontArialSC.setChecked(false);
                    fontComiSansSC.setChecked(false);
                    fontTahomaSC.setChecked(false);
                    fontTrebuchetSC.setChecked(false);
                    fontVerdanaSC.setChecked(false);
                    changeFontFamily(this, R.font.helvetica);
                    GlobalVariables.getInstance().setFontFamilySwitch(buttonView.getId());
                } else if (!fontComiSansSC.isChecked() & !fontComiSansSC.isChecked() & !fontTahomaSC.isChecked() &
                        !fontTrebuchetSC.isChecked() & !fontVerdanaSC.isChecked()) {
                    fontHelveticaSC.setChecked(true);
                }
                break;
            case R.id.fontTahomaSC:
                if (isChecked) {
                    fontArialSC.setChecked(false);
                    fontComiSansSC.setChecked(false);
                    fontHelveticaSC.setChecked(false);
                    fontTrebuchetSC.setChecked(false);
                    fontVerdanaSC.setChecked(false);
                    changeFontFamily(this, R.font.tahoma);
                    GlobalVariables.getInstance().setFontFamilySwitch(buttonView.getId());
                } else if (!fontComiSansSC.isChecked() & !fontComiSansSC.isChecked() & !fontHelveticaSC.isChecked() &
                        !fontTrebuchetSC.isChecked() & !fontVerdanaSC.isChecked()) {
                    fontTahomaSC.setChecked(true);
                }
                break;
            case R.id.fontTrebuchetSC:
                if (isChecked) {
                    fontArialSC.setChecked(false);
                    fontComiSansSC.setChecked(false);
                    fontHelveticaSC.setChecked(false);
                    fontTahomaSC.setChecked(false);
                    fontVerdanaSC.setChecked(false);
                    changeFontFamily(this, R.font.trebuchet);
                    GlobalVariables.getInstance().setFontFamilySwitch(buttonView.getId());
                } else if (!fontComiSansSC.isChecked() & !fontComiSansSC.isChecked() & !fontHelveticaSC.isChecked() &
                        !fontTahomaSC.isChecked() & !fontVerdanaSC.isChecked()) {
                    fontTrebuchetSC.setChecked(true);
                }
                break;
            case R.id.fontVerdanaSC:
                if (isChecked) {
                    fontArialSC.setChecked(false);
                    fontComiSansSC.setChecked(false);
                    fontHelveticaSC.setChecked(false);
                    fontTahomaSC.setChecked(false);
                    fontTrebuchetSC.setChecked(false);
                    changeFontFamily(this, R.font.verdana);
                    GlobalVariables.getInstance().setFontFamilySwitch(buttonView.getId());
                } else if (!fontComiSansSC.isChecked() & !fontComiSansSC.isChecked() & !fontHelveticaSC.isChecked() &
                        !fontTahomaSC.isChecked() & !fontTrebuchetSC.isChecked()) {
                    fontVerdanaSC.setChecked(true);
                }
                break;
            case R.id.blueThemeSC:
                if (isChecked) {
                    darkYellowThemeSC.setChecked(false);
                    greenThemeSC.setChecked(false);
                    changeAppTheme(getResources().getColor(R.color.blueTheme));
                    GlobalVariables.getInstance().setThemeSwitch(buttonView.getId());
                } else if (!darkYellowThemeSC.isChecked() & !greenThemeSC.isChecked())
                    blueThemeSC.setChecked(true);
                break;
            case R.id.darkYellowThemeSC:
                if (isChecked) {
                    blueThemeSC.setChecked(false);
                    greenThemeSC.setChecked(false);
                    changeAppTheme(getResources().getColor(R.color.darkYellowTheme));
                    GlobalVariables.getInstance().setThemeSwitch(buttonView.getId());
                } else if (!blueThemeSC.isChecked() & !greenThemeSC.isChecked())
                    darkYellowThemeSC.setChecked(true);
                break;
            case R.id.greenThemeSC:
                if (isChecked) {
                    blueThemeSC.setChecked(false);
                    darkYellowThemeSC.setChecked(false);
                    changeAppTheme(getResources().getColor(R.color.greenTheme));
                    GlobalVariables.getInstance().setThemeSwitch(buttonView.getId());
                } else if (!blueThemeSC.isChecked() & !darkYellowThemeSC.isChecked())
                    greenThemeSC.setChecked(true);
                break;
        }
    }

    private void changeTextSize(int textSize) {
        textSizeNote.setTextSize(TypedValue.COMPLEX_UNIT_PT, textSize);
        smallTV.setTextSize(TypedValue.COMPLEX_UNIT_PT, textSize);
        mediumTV.setTextSize(TypedValue.COMPLEX_UNIT_PT, textSize);
        largeTV.setTextSize(TypedValue.COMPLEX_UNIT_PT, textSize);

        textFontNote.setTextSize(TypedValue.COMPLEX_UNIT_PT, textSize);
        arialTV.setTextSize(TypedValue.COMPLEX_UNIT_PT, textSize);
        comisansTV.setTextSize(TypedValue.COMPLEX_UNIT_PT, textSize);
        helveticaTV.setTextSize(TypedValue.COMPLEX_UNIT_PT, textSize);
        tahomaTV.setTextSize(TypedValue.COMPLEX_UNIT_PT, textSize);
        trebuchetTV.setTextSize(TypedValue.COMPLEX_UNIT_PT, textSize);
        verdanaTV.setTextSize(TypedValue.COMPLEX_UNIT_PT, textSize);

        textThemeNote.setTextSize(TypedValue.COMPLEX_UNIT_PT, textSize);
        blueThemeTV.setTextSize(TypedValue.COMPLEX_UNIT_PT, textSize);
        darkYellowThemeTV.setTextSize(TypedValue.COMPLEX_UNIT_PT, textSize);
        greenThemeTV.setTextSize(TypedValue.COMPLEX_UNIT_PT, textSize);

        GlobalVariables.getInstance().setGlobalTextSize(textSize);
    }

    private void changeFontFamily(AppSettings appSettings, int fontFamily) {
        textSizeNote.setTypeface(ResourcesCompat.getFont(appSettings, fontFamily));
        smallTV.setTypeface(ResourcesCompat.getFont(appSettings, fontFamily));
        mediumTV.setTypeface(ResourcesCompat.getFont(appSettings, fontFamily));
        largeTV.setTypeface(ResourcesCompat.getFont(appSettings, fontFamily));

        textFontNote.setTypeface(ResourcesCompat.getFont(appSettings, fontFamily));
        arialTV.setTypeface(ResourcesCompat.getFont(appSettings, fontFamily));
        comisansTV.setTypeface(ResourcesCompat.getFont(appSettings, fontFamily));
        helveticaTV.setTypeface(ResourcesCompat.getFont(appSettings, fontFamily));
        tahomaTV.setTypeface(ResourcesCompat.getFont(appSettings, fontFamily));
        trebuchetTV.setTypeface(ResourcesCompat.getFont(appSettings, fontFamily));
        verdanaTV.setTypeface(ResourcesCompat.getFont(appSettings, fontFamily));

        textThemeNote.setTypeface(ResourcesCompat.getFont(appSettings, fontFamily));
        blueThemeTV.setTypeface(ResourcesCompat.getFont(appSettings, fontFamily));
        darkYellowThemeTV.setTypeface(ResourcesCompat.getFont(appSettings, fontFamily));
        greenThemeTV.setTypeface(ResourcesCompat.getFont(appSettings, fontFamily));

        GlobalVariables.getInstance().setGlobalFontFamily(fontFamily);
    }

    private void changeAppTheme(int themeColor) {
        mainViews.setBackgroundColor(themeColor);
        GlobalVariables.getInstance().setGlobalThemeColor(themeColor);
    }

    private void performDefaultSettings() {
        changeTextSize(GlobalVariables.getInstance().getGlobalTextSize());
        changeFontFamily(this, GlobalVariables.getInstance().getGlobalFontFamily());
        changeAppTheme(GlobalVariables.getInstance().getGlobalThemeColor());

        SwitchCompat temp;

        if (GlobalVariables.getInstance().getFontSizeSwitch() != 0) {
            temp = findViewById(GlobalVariables.getInstance().getFontSizeSwitch());
            temp.performClick();
        }

        if (GlobalVariables.getInstance().getThemeSwitch() != 0) {
            temp = findViewById(GlobalVariables.getInstance().getThemeSwitch());
            temp.performClick();
        }

        if (GlobalVariables.getInstance().getFontFamilySwitch() != 0) {
            temp = findViewById(GlobalVariables.getInstance().getFontFamilySwitch());
            temp.performClick();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}

