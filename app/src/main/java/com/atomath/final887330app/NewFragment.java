package com.atomath.final887330app;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.codemobiles.util.CMFeedXmlUtil;
import com.codemobiles.util.CMXmlJsonConvertor;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewFragment extends Fragment {
    private static final String TITLE = "title";
    private static final String DESC = "directed";
    private static final String PIC = "picture_link";




    ArrayList<HashMap<String, String>> xmllist = new ArrayList<HashMap<String, String>>();

    private ListView listview;
    public NewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_new, container, false);
        listview = (ListView) v.findViewById(R.id.listview);
        /*listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {

                ListViewAdapter.viewHolder holder = (ListViewAdapter.viewHolder) v.getTag();

                Intent i = new Intent(getContext(), DetailActivity.class);
                i.putExtra(TITLE, holder.title.getText().toString());
                i.putExtra(DESC, holder.description.getText().toString());
                i.putExtra(IMG_LINK, holder.image_link_url);
                i.putExtra(IMG_YOUTUBE, holder.youtube_image_url);
                i.putExtra(YOUTUBE_ID, holder.youtubeID);
                startActivity(i);

            }
        });*/
        feedData();
        return v;
    }

    private void feedData() {
        //set listview adapter


        new FeedAsynTask().execute("http://10.51.4.15/887330/films/index.php/movie/relsase/format/xml");
    }

    public class FeedAsynTask extends AsyncTask<String, Void, ArrayList<HashMap<String, String>>> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected ArrayList<HashMap<String, String>> doInBackground(String... params) {
            RequestBody request = new FormEncodingBuilder()
                    .add("type","xml")
                    .build();
            ArrayList<Object> result = CMFeedXmlUtil.feed(params[0], "movie", request);
            for (int i = 0; i < result.size(); i++) {


                Object item = result.get(i);
                HashMap<String, String> map = new HashMap<String, String>();

                map.put(TITLE, CMXmlJsonConvertor.getValue(item,TITLE));
                map.put(DESC, CMXmlJsonConvertor.getValue(item, DESC));
                map.put(PIC, CMXmlJsonConvertor.getValue(item, PIC));

                xmllist.add(map);

            }

            return xmllist;
        }

        @Override
        protected void onPostExecute(ArrayList<HashMap<String, String>> s) {
            super.onPostExecute(s);
            listview.setAdapter(new ListViewAdapter_new(getActivity(), new ArrayList<HashMap<String, String>>(s)));
            Log.i("cp", "onPostExecute: "+s.size());
        }


    }
}
