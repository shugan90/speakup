package com.example.speakup;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class AlphaAdapter extends RecyclerView.Adapter<AlphaAdapter.alphaViewHolder> {
    Context mContext;
    List<MainTable> mData;
    TextToSpeech textToSpeech;

    public AlphaAdapter(Context mContext, List<MainTable> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public AlphaAdapter.alphaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.item_view, parent, false);
        return new alphaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull alphaViewHolder holder, final int position) {
        textToSpeech = new TextToSpeech(mContext, status -> {
            if (status != TextToSpeech.ERROR) {
                textToSpeech.setLanguage(Locale.UK);
            }
        });
        int imgID = mContext.getResources().getIdentifier(mData.get(position).alphaIcon, "drawable", mContext.getPackageName());
        holder.alphaImg.setImageDrawable(ContextCompat.getDrawable(mContext, imgID));
        holder.alphaName.setText(mData.get(position).getAlphaWord());
        holder.buttonAlpha.setOnClickListener(v -> textToSpeech.speak(mData.get(position).getAlphaWord(), TextToSpeech.QUEUE_FLUSH, null));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class alphaViewHolder extends RecyclerView.ViewHolder {
        ImageView alphaImg;
        TextView alphaName;
        Button buttonAlpha;

        public alphaViewHolder(@NonNull View itemView) {
            super(itemView);
            alphaImg = itemView.findViewById(R.id.alphaImg);
            alphaName = itemView.findViewById(R.id.alphaName);
            buttonAlpha = itemView.findViewById(R.id.buttonAlpha);

            alphaName.setTextSize(TypedValue.COMPLEX_UNIT_PT, GlobalVariables.getInstance().getGlobalTextSize());
            alphaName.setTypeface(ResourcesCompat.getFont(mContext, GlobalVariables.getInstance().getGlobalFontFamily()));
            buttonAlpha.setTextSize(TypedValue.COMPLEX_UNIT_PT, GlobalVariables.getInstance().getGlobalTextSize());
            buttonAlpha.setTypeface(ResourcesCompat.getFont(mContext, GlobalVariables.getInstance().getGlobalFontFamily()));

        }
    }
}
