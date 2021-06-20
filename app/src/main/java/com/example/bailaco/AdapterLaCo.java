package com.example.bailaco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterLaCo extends BaseAdapter {

    private Context context;
    private  int Layout;
    List<ClassCo> coList;

    public AdapterLaCo(Context context, int layout, List<ClassCo> coList) {
        this.context = context;
        Layout = layout;
        this.coList = coList;
    }

    @Override
    public int getCount() {
        return coList.size();
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(Layout, null);

        // ánh xạ
        TextView txt1 = (TextView) convertView.findViewById(R.id.textView1);
        TextView txt2 = (TextView) convertView.findViewById(R.id.textView2);
        ImageView img = (ImageView) convertView.findViewById(R.id.imageView);

       // gán giá trị
        ClassCo co = coList.get(position);

        txt1.setText(co.getText1());
        txt2.setText(co.getText2());
        img.setImageResource(co.getAnh());

        return convertView;
    }
}
