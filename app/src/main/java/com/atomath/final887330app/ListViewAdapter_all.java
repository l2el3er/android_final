package com.atomath.final887330app;

/**
 * Created by atomath on 12/4/59.
 */

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by atomath on 25/2/59.
 */
public class ListViewAdapter_all extends BaseAdapter {
    private static final String TITLE = "title";
    private static final String DESC = "directed";
    private static final String PIC = "picture_link";

    public Context mContext;
    public LayoutInflater mInflater;
    public ArrayList<HashMap<String, String>> mData;

    public ListViewAdapter_all(Context context, ArrayList<HashMap<String, String>> arrayList){
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mData = arrayList;
        Log.i("final_adapter", mData.toString());

    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Log.i("final_adapter", "getView: ");
        viewHolder holder = null;
        HashMap<String, String> item = mData.get(position);
        if(convertView == null){
            // load layout
            convertView = mInflater.inflate(R.layout.item_listview_all,null);

            holder = new viewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.txtNameMovie);
           // holder.description = (TextView) convertView.findViewById(R.id.txtNameDirector);
           // holder.image_link = (ImageView) convertView.findViewById(R.id.imgPoster);
            //holder.youtube_image = (ImageView) convertView.findViewById(R.id.item_listview_youtube_image);




        }else{
            //restoration

            holder = (viewHolder) convertView.getTag();

        }
        holder.title.setText(item.get(TITLE));
        holder.imgPoster = item.get(PIC);
        holder.direct = item.get(DESC);
        holder.desc = item.get("desc");



        convertView.setTag(holder);

        return convertView;
    }

    public class viewHolder{
        TextView title;
        String imgPoster;
        String direct;
        String desc;
    }
}

