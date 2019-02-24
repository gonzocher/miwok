package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    /**Resource ID for the background color for this list of words*/
    private int mColorResourceId;

    /**
     * Create a new {@link WordAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param words is the list of {@link Word}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */

public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
    super(context,0,words);
    mColorResourceId = colorResourceId;
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

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage() ) {
            //Set the image to the resource
            imageView.setImageResource(currentWord.getmImageResourceId());
            //Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            //Otherwise, hide the image view
            imageView.setVisibility(View.GONE);
        }

        //Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        //Set the background color of the text container view
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
