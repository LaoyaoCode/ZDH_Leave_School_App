package com.laoyao.normal.whutzdh15.Tools;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.laoyao.normal.whutzdh15.R;

import java.util.List;

/**
 * Created by Laoyao on 2018/4/2.
 */

public class PopUpAdapter extends RecyclerView.Adapter<PopUpAdapter.RViewHolder>
{
    private List<String> DisplayWords ;
    private Context GiveContext ;
    private PopUpClickInterface PUClick = null ;
    private Dialog MDialog = null ;

    static class RViewHolder extends RecyclerView.ViewHolder
    {
        public View RootView ;
        public TextView DisplayWords ;

        public RViewHolder(View view)
        {
            super(view);

            RootView = view ;
            DisplayWords = (TextView)view.findViewById(R.id.pop_up_item_dis_text) ;
        }
    }

    public PopUpAdapter(List<String> words , Context context, PopUpClickInterface puClick, Dialog dialog )
    {
        DisplayWords = words ;
        GiveContext = context ;
        PUClick = puClick ;
        MDialog = dialog ;
    }

    @Override
    public RViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pop_up_item , parent , false) ;
        RViewHolder holder = new RViewHolder(view) ;
        return holder ;
    }

    @Override
    public void onBindViewHolder(RViewHolder holder, int position)
    {
        final String words = DisplayWords.get(position) ;

        //设置显示的文字
        holder.DisplayWords.setText(words);
        //设置底部可以点击
        holder.RootView.setClickable(true);
        holder.RootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PUClick.Click(words);
                MDialog.dismiss();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return DisplayWords.size();
    }
}
