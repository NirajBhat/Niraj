package com.bridgelabz.customlistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by bridgeit on 2/11/16.
 */

public class CustomList extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] itemname;
    private final Integer[] integers;

    public CustomList(Activity context, String[] itemname, Integer[] imgid) {
        super(context, R.layout.image, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.integers=imgid;
    }

  /*  public CustomList(Activity context, String[] itemname,
                      Integer[] integers) {
        super(context, R.layout.image, itemname);
        // auto generated constructor
        this.context = context;
        this.itemname = itemname;
        this.integers = integers;
    }*/

   /* public View getview(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.image, null);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(integers[position]);
        extratxt.setText("Description " + itemname[position]);
        return rowView;
    }
*/

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.image, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(integers[position]);
        extratxt.setText("Description "+itemname[position]);
        return rowView;

    };
}