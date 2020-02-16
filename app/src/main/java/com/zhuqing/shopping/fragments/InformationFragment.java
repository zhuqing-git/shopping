package com.zhuqing.shopping.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zhuqing.shopping.R;
import com.zhuqing.shopping.entity.Msg;

import java.util.ArrayList;
import java.util.List;

public class InformationFragment extends Fragment implements View.OnClickListener{

   // private final Context context;

//   public InformationFragment(Context context){
//        this.context=context;
//    }

    private List<Msg>msgList=new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private InformationAdapter adapter;



    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_information,container,false);
        inputText=view.findViewById(R.id.information_input_text);
        send=view.findViewById(R.id.information_send_button);
        msgRecyclerView=view.findViewById(R.id.information_recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(view.getContext());
        adapter=new InformationAdapter(msgList);
        msgRecyclerView.setLayoutManager(layoutManager);
        msgRecyclerView.setAdapter(adapter);

        InitMsgs();


        send.setOnClickListener(this);

        return view;
    }

    private void InitMsgs() {
        Msg msg1=new Msg("Hello guy.",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2=new Msg("Hello. Who is that?",Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3=new Msg("This is Tom .",Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.information_send_button:
                String content=inputText.getText().toString();
                if(!"".equals(content))
                {
                    Msg msg=new Msg(content,Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size()-1);
                    inputText.setText("");
                }
        }
    }


    public static class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.InfoViewHolder>{

private List<Msg> msgList;
static class InfoViewHolder extends RecyclerView.ViewHolder {
    LinearLayout leftLayout,rightLayout;
    TextView leftMsg,rightMsg;

    public InfoViewHolder(@NonNull View itemView) {
        super(itemView);
        leftLayout=itemView.findViewById(R.id.item_information_left_layout);
        rightLayout=itemView.findViewById(R.id.item_information_right_layout);
        leftMsg=itemView.findViewById(R.id.item_information_left_msg);
        rightMsg=itemView.findViewById(R.id.item_information_right_msg);
    }
}


public InformationAdapter(List<Msg> mL){
    this.msgList=mL;

}

        @NonNull
        @Override
        public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_information,parent,false);
           InfoViewHolder infoViewHolder=new InfoViewHolder(view);
           return infoViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull InfoViewHolder holder, int position) {
            Msg msg=msgList.get(position);
            if (msg.getType()==Msg.TYPE_RECEIVED)
            {
                holder.leftLayout.setVisibility(View.VISIBLE);
                holder.rightLayout.setVisibility(View.GONE);
                holder.leftMsg.setText(msg.getContent());
            }
            else if(msg.getType()==Msg.TYPE_SENT)
            {
                holder.leftLayout.setVisibility(View.GONE);
                holder.rightLayout.setVisibility(View.VISIBLE);
                holder.rightMsg.setText(msg.getContent());
            }
        }



        @Override
        public int getItemCount() {
            return msgList.size();
        }
    }

}
