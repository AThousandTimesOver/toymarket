package com.example.jmy.toy_me_message;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.widget.ListView;




///**
// * A simple {@link Fragment} subclass.
// * Use the {@link OneFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class Three3Fragment extends Fragment {

    private ListView lv_teacher;

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;


    public Three3Fragment() {
        // Required empty public constructor
    }

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment OneFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static OneFragment newInstance(String param1, String param2) {
//        OneFragment fragment = new OneFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        View view = inflater.inflate(R.layout.fragment_one, container, false);
//        //ButterKnife.bind(this, view);
//        initData();
//        return view;


        View view = inflater.inflate(R.layout.fragment_three3, container, false);
        lv_teacher = (ListView) view.findViewById(R.id.list);

        //给链表添加数据
        List<Map<String, Object>> list=getData();
        //适配器，刚刚重写的！
        zulin_yifu_Adapter myAdapter = new zulin_yifu_Adapter(getActivity(), list);
        //设置适配器
        lv_teacher.setAdapter(myAdapter);

        //return view;
        // Inflate the layout for this fragment
        return view;
        //inflater.inflate(R.layout.fragment_one, container, false);
    }

    //填充数据
    public List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 1; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", R.drawable.cw);
            map.put("ID_name", "jellycat公司");
            map.put("teacher_name", "💲2");
            map.put("teacher_nickname", "超可爱小刺猬 棕色");
            map.put("university", "x5");
            map.put("state", "已付款");
            map.put("zongjiage", "💲10");
            map.put("zulinshichang", "租赁时长：三十天");
            list.add(map);
        }
        return list;
    }

//    private List<Map<String, Object>> initData() {
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//        for (int i = 0; i < 10; i++) {
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("image", R.drawable.ic_menu_share);
//            map.put("ID_name", "漫威公司");
//            map.put("teacher_name", "💲1000");
//            map.put("teacher_nickname", "美国队长 红色");
//            map.put("university", "x2");
//            map.put("state", "已完成");
//            map.put("zongjiage", "💲2000");
//            list.add(map);
//        }
//        lvAdapter = new goumai_quanbu_Adapter(getActivity(), list);
//        lv.setAdapter(lvAdapter);
//
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getActivity(), stringList.get(i).toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getActivity(), "long click:" + stringList.get(i).toString(), Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });
//        return list;
//    }



}
