package com.kiksoft.altmenu.dosyalarim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kiksoft.kikmobil.R;
import com.celerysoft.tablefixheaders.adapter.BaseTableAdapter;

public abstract class SampleTableAdapter extends BaseTableAdapter {

    private final Context context;
    private final LayoutInflater inflater;

    public SampleTableAdapter(Context context)
    {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    public Context getContext()
    {
        return context;
    }

    public LayoutInflater getInflater()
    {
        return inflater;
    }


    @Override
    public View getView(int row, int column, View converView, ViewGroup parent)
    {
        if (converView == null) {
            converView = inflater.inflate(getLayoutResource(row, column),
                    parent, false);
        }
        setText(converView, getCellString(row, column));
        return converView;
    }


    private void setText(View view, String text)
    {
        ((TextView) view.findViewById(R.id.table_item_text)).setText(text);
    }


    public abstract String getCellString(int row, int column);

    public abstract int getLayoutResource(int row, int column);





}







