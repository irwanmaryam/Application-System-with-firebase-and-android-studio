package com.example.muazarresources;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter {

    private Activity mContext;
    List<Users> usersList;

    public ListAdapter(Activity mContext, List<Users>usersList){
        super(mContext,R.layout.list_item,usersList);
        this.mContext = mContext;
        this.usersList = usersList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.list_item,null, true);

        TextView tvsName = listItemView.findViewById(R.id.tvSName);
        TextView tvage = listItemView.findViewById(R.id.tvAge);
       // TextView tvpName = listItemView.findViewById(R.id.tvPName);
        TextView tvschool = listItemView.findViewById(R.id.tvSchool);
        TextView tvsession = listItemView.findViewById(R.id.tvSession);

        Users users = usersList.get(position);

        tvsName.setText(users.getsName());
        tvage.setText(users.getage());
      //  tvpName.setText(users.getpName());
        tvschool.setText(users.getschool());
        tvsession.setText(users.getsession());

        return listItemView;

    }
}
