package idv.jerryexcc.vo_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<HumanVo> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView = findViewById(R.id.recyclerView);
        list.add(new HumanVo("Mary", "Girl", 20));
        list.add(new HumanVo("Sammy", "Boy", 87));
        list.add(new HumanVo("Ugly", "Monster", 66));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new CardAdapter(list));
    }


    private class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
        private List<HumanVo> list;

        public CardAdapter(List<HumanVo> cardList) {
            this.list = cardList;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView tvName, tvGender, tvAge;

            public ViewHolder(final View itemView) {
                super(itemView);
                tvName = itemView.findViewById(R.id.tvName);
                tvGender = itemView.findViewById(R.id.tvGender);
                tvAge = itemView.findViewById(R.id.tvAge);
            }
        }

        @NonNull
        @Override
        public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, int position) {
            holder.tvName.setText(list.get(position).getName());
            holder.tvGender.setText(list.get(position).getGender());
            holder.tvAge.setText(list.get(position).getAge() + "");
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }
}
