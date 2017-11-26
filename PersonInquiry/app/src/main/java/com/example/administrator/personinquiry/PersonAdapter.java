package com.example.administrator.personinquiry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/10/5.
 */

public class PersonAdapter extends ArrayAdapter<Person>{
    private int resourceId;

    public PersonAdapter(Context context, int textViewResourceId,
                         Person[] objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Person person = getItem(position); // 获取当前项的person实例
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.text1 = (TextView) view.findViewById (R.id.text1);
            viewHolder.text2 = (TextView) view.findViewById (R.id.text2);
            viewHolder.text3 = (TextView) view.findViewById (R.id.text3);
            viewHolder.text4 = (TextView) view.findViewById (R.id.text4);
            viewHolder.portrait_item = (ImageView) view.findViewById (R.id.portrait_item);


            view.setTag(viewHolder); // 将ViewHolder存储在View中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
        }

        viewHolder.text1.setText(person.getNumber());
        viewHolder.text2.setText(person.getName());
        viewHolder.text3.setText(person.getGender());
        viewHolder.text4.setText(person.getAddress());
        viewHolder.portrait_item.setImageResource(person.getPortraitId());
        return view;
    }

    class ViewHolder {

        TextView text1;
        TextView text2;
        TextView text3;
        TextView text4;
        ImageView portrait_item;

    }



}
