package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

public WordAdapter(Activity context, ArrayList<Word> words) {
    super(context,0,words);
}



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Word currentWord = getItem(position);

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        TextView defaultTranslationView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTranslationView.setText(currentWord.getDefaultTranslation());

        TextView miwokTranslationView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTranslationView.setText(currentWord.getMiwokTranslation());


        return listItemView;
    }
}
