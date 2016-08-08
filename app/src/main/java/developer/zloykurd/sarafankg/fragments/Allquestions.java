package developer.zloykurd.sarafankg.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import developer.zloykurd.sarafankg.QuestionCreate;
import developer.zloykurd.sarafankg.SelectQuestionActivity;
import developer.zloykurd.sarafankg.adapters.GetAdapterforNDView;
import developer.zloykurd.sarafankg.db.DataBase;

/**
 * Created by ZloykurD on 07.08.2016.
 */
public class Allquestions extends Fragment {
    GetAdapterforNDView adapter;
    ListView list;
    public Allquestions() {
    }
    final String LOG_TAG = "Allquestions";
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list = (ListView) getActivity().findViewById(developer.zloykurd.sarafankg.R.id.ListI);
        adapter = new GetAdapterforNDView(getActivity(), getData(),
                getActivity().getApplicationContext());// mStrings
        list.setAdapter(adapter);
    }

    public void onItemClick(ListView l, View v, int position, long id) {
//        String item = (String) getListAdapter().getItem(position);
        Intent i = new Intent(getActivity(), SelectQuestionActivity.class);
        i.putExtra("mPosition", position);
        startActivity(i);
    }
    private ArrayList<QuestionCreate> getData() {
        DataBase db = new DataBase(getActivity().getApplicationContext());
        final ArrayList<QuestionCreate> stringItems = new ArrayList<QuestionCreate>();
        ArrayList<QuestionCreate> pr = (ArrayList<QuestionCreate>) db.getAllQuestions();
        for (QuestionCreate p : pr) {
            stringItems.add(p);
        }
        Log.d("LogTest","stringItems" + stringItems.toString());
        db.close();
        return stringItems;

    }


}
