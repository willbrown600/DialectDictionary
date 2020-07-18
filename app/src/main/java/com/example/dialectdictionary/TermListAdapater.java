package com.example.dialectdictionary;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Objects;

public class TermListAdapater extends ArrayAdapter<VocabTerm> {

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    /**
     * Holds variables in a View
     */
    private static class ViewHolder {
        TextView term;
        TextView definition;
    }

    public TermListAdapater(Context context, int resource, ArrayList<VocabTerm> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the persons information
        String term = Objects.requireNonNull(getItem(position)).getTerm();
        String definition = Objects.requireNonNull(getItem(position)).getDefinition();

        //Create the VocabTerm object with the information
        VocabTerm word = new VocabTerm(term, definition);

        //create the view result for showing the animation
        final View result;

        //ViewHolder object
        ViewHolder holder;


        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder= new ViewHolder();
            holder.term = convertView.findViewById(R.id.textView1);
            holder.definition = convertView.findViewById(R.id.textView2);

            result = convertView;

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }


        Animation animation = AnimationUtils.loadAnimation(mContext,
                (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
        result.startAnimation(animation);
        lastPosition = position;

        holder.term.setText(word.getTerm());
        holder.definition.setText(word.getDefinition());


        return convertView;
    }

}
