package developer.zloykurd.sarafankg.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import developer.zloykurd.sarafankg.QuestionCreate;
import developer.zloykurd.sarafankg.R;
import developer.zloykurd.sarafankg.SelectQuestionActivity;

/**
 * Created by ZloykurD on 07.08.2016.
 */
public class GetAdapterforNDView  extends BaseAdapter implements
        View.OnClickListener {


    final String LOG_TAG = "NoteLog";
    private Activity activity;
    private String[] data;
    private ArrayList<QuestionCreate> rData = new ArrayList<QuestionCreate>();


    private static LayoutInflater inflater = null;
    private Context mContext;


    public GetAdapterforNDView(Activity a, ArrayList<QuestionCreate> rD,
                                Context context) {
        this.mContext = context;
        activity = a;
        rData = rD;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    public int getCount() {

        return rData.size();

    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onClick(View v) {

    }

    /*********
     * Create a holder Class to contain inflated xml file elements
     *********/
    public static class ViewHolder {
        public ImageView imgQ;
        public TextView lqcretor;
        public TextView lqcoutncommemts;
        public TextView lqtext;
        public TextView lqcategory;
        public TextView lqdate;



    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        ViewHolder holder;

        if (convertView == null) {
            //****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            vi = inflater.inflate(R.layout.list_show_all_qitems, null);

            /****** View Holder Object to contain tabitem.xml file elements ******/

            holder = new ViewHolder();
            holder.imgQ = (ImageView) vi.findViewById(R.id.frag_imageView);
            holder.lqcretor = (TextView) vi.findViewById(R.id.frag_name);
            holder.lqcoutncommemts= (TextView) vi.findViewById(R.id.frag_num);
            holder.lqtext= (TextView) vi.findViewById(R.id.frag_quest);
            holder.lqcategory= (TextView) vi.findViewById(R.id.frag_category);
            holder.lqdate= (TextView) vi.findViewById(R.id.tvlqdate);



            /************ Set holder with LayoutInflater ************/
            vi.setTag(holder);
        } else {
            holder = (ViewHolder) vi.getTag();
        }


        QuestionCreate item = rData.get(position);
        //Log.d(LOG_TAG, item.toString());
        Context context = parent.getContext();


        //holder.imgQ.setBackgroundResource(item.getImageAccountUser());
        holder.lqcretor.setText(item.getCreatorQuestion());
        holder.lqcoutncommemts.setText(item.getCountCommyQuestion());
        holder.lqtext.setText(item.getTextQuestion());
        holder.lqcategory.setText(item.getCategoryQuestion());
        holder.lqdate.setText(item.getDateQuestion());



        /******** Set Item Click Listner for LayoutInflater for each row ***********/
        vi.setOnClickListener(new OnItemClickListener(item));
        return vi;
    }

    private class OnItemClickListener implements View.OnClickListener {
        private QuestionCreate item;

        OnItemClickListener(QuestionCreate lilteQuestion){item = lilteQuestion;}
        @Override
        public void onClick(View arg0) {
            Toast.makeText(activity, "Toast", Toast.LENGTH_SHORT).show();
            Intent myIntent = new Intent(mContext, SelectQuestionActivity.class);
            myIntent.putExtra("lqcretor",item.getCreatorQuestion());
            myIntent.putExtra("lqcoutncommemts",item.getCountCommyQuestion());
            myIntent.putExtra("lqtext",item.getTextQuestion());
            myIntent.putExtra("lqcategory",item.getCategoryQuestion());
            myIntent.putExtra("lqdate",item.getDateQuestion());
            myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(myIntent);
        }
    }

}