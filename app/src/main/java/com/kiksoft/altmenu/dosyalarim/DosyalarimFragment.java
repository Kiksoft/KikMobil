package com.kiksoft.altmenu.dosyalarim;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.celerysoft.tablefixheaders.TableFixHeaders;
import com.kiksoft.kikmobil.R;


public class DosyalarimFragment extends Fragment {






    public DosyalarimFragment() {

    }



//    static String[] tableHeaders={"Dosya Türü","Dosya Numarası","Dosya Tarihi","İşin Tanımı","İşin Türü", "Durum", "Firma Adı"};
//
//    static String[][] spaceProbes={
//            {"1","Pioneer","Chemical","Jupiter","abc","abc","abc"},
//            {"2","Voyager","Plasma","Andromeda","abc","abc","abc"},
//            {"3","Casini","Solar","Saturn","abc","abc","abc"},
//            {"4","Spitzer","Anti-Matter","Andromeda","abc","abc","abc"},
//            {"5","Apollo","Chemical","Moon","abc","abc","abc"},
//            {"6","Curiosity","Solar","Mars","abc","abc","abc"},
//
//
//    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.table, container, false);
        TableFixHeaders tableFixHeaders = (TableFixHeaders)view.findViewById(R.id.table);
        tableFixHeaders.setRowSelectable(true);
        tableFixHeaders.setAdapter(new MyAdapter(view.getContext()));
        return view;

        ///eski table kodları
//        View view = inflater.inflate(R.layout.my_files_fragment, container, false);
//        final TableView<String[]> tableView = (TableView<String[]>) view.findViewById(R.id.table_myfiles);
//        tableView.setHeaderBackgroundColor(Color.parseColor("#2ecc71"));
//        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(view.getContext(), tableHeaders));
//        tableView.setColumnCount(7);
//        tableView.setDataAdapter(new SimpleTableDataAdapter(view.getContext(), spaceProbes));
//        return view;


    }




    public class MyAdapter extends SampleTableAdapter
    {

        private final int width;
        private final int height;

        private final int VIEW_TYPE_HEADER = 0;
        private final int VIEW_TYPE_ITEM = 1;
        private final int VIEW_TYPE_COUNT = 2;

        public MyAdapter(Context context)
        {
            super(context);

            Resources resources = context.getResources();

            width = resources.getDimensionPixelSize(R.dimen.table_width);
            height = resources.getDimensionPixelSize(R.dimen.table_height);
        }

        @Override
        public int getRowCount()
        {
            return 25;
        } // son 3 satır alt menüden dolayı ekranda görülmedi

        @Override
        public int getColumnCount()
        {
            return 15;
        }

        @Override
        public int getWidth(int column)
        {
            return width;
        }

        @Override
        public int getHeight(int row)
        {
            return height;
        }

        @Override
        public String getCellString(int row, int column)
        {
            return "Kik-Soft (" + row + ", " + column + ")";
        }

        @Override
        public int getLayoutResource(int row, int column)
        {
            final int layoutResource;
            switch (getItemViewType(row, column)) {
                case VIEW_TYPE_HEADER:
                    layoutResource = R.layout.item_style_table_header;
                    break;
                case VIEW_TYPE_ITEM:
                    layoutResource = R.layout.item_style_table;
                    break;
                default:
                    throw new RuntimeException("wtf?");
            }
            return layoutResource;
        }

        @Override
        public int getItemViewType(int row, int column)
        {
            if (row < 0) {
                return VIEW_TYPE_HEADER;
            } else {
                return VIEW_TYPE_ITEM;
            }
        }

        @Override
        public int getViewTypeCount()
        {
            return VIEW_TYPE_COUNT;
        }

        @Override
        public int getBackgroundResId(int row, int column)
        {
            final int backgroundResource;
            switch (getItemViewType(row, column)) {
                case VIEW_TYPE_HEADER:
                    backgroundResource = R.drawable.item_style_table_header;
                    break;
                case VIEW_TYPE_ITEM:
                    backgroundResource = R.drawable.item_style_table;
                    break;
                default:
                    throw new RuntimeException("wtf?");
            }
            return backgroundResource;
        }

        @Override
        public int getBackgroundHighlightResId(int row, int column) {
            return R.drawable.item_highlight_rect;
        }

        @Override
        public boolean isRowSelectable(int row) {
            return true;
        }

        @Override
        public long getItemId(int row, int column) {
            return 0;
        }

        @Override
        public Object getItem(int row, int column) {
            return null;
        }
    }




}
