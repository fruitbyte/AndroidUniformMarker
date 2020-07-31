package com.won_tonsoup.uniformmarker;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DataRecyclerAdapter extends RecyclerView.Adapter<DataRecyclerAdapter.ViewHolder> implements Filterable{

    private List<DataSender> cadetList;
    private List<DataSender> cadetListFull;

    View view;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView cardview_last;
        TextView cardview_first;
        TextView cardview_flight;
        TextView cardview_score;
        TextView cardview_fixmessage;

        public ViewHolder(final View itemView) {
            super(itemView);
            cardview_flight = itemView.findViewById(R.id.cardview_flight);
            cardview_last = itemView.findViewById(R.id.cardview_last);
            cardview_first = itemView.findViewById(R.id.cardview_first);
            cardview_score = itemView.findViewById(R.id.cardview_score);
            cardview_fixmessage = itemView.findViewById(R.id.cardview_fixmessage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(), IndividualData.class);
                    String first = cardview_first.getText().toString();
                    String last = cardview_last.getText().toString();
                    String flight = cardview_flight.getText().toString();
                    String flightString = String.valueOf(flight);
                    String score = cardview_score.getText().toString();
                    String fixmessage = cardview_fixmessage.getText().toString();
                    intent.putExtra("first", first);
                    intent.putExtra("last", last);
                    intent.putExtra("flight", flightString);
                    intent.putExtra("score", score);
                    intent.putExtra("fixmessage", fixmessage);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }

    DataRecyclerAdapter(List<DataSender> cadetList) {
        this.cadetList = cadetList;
        cadetListFull = new ArrayList<>(cadetList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.date_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataSender currentProfile = cadetList.get(position);
        holder.cardview_last.setText(currentProfile.getLast());
        holder.cardview_first.setText(currentProfile.getFirst());
        holder.cardview_flight.setText(String.valueOf(currentProfile.getFlight()));
        holder.cardview_score.setText(String.valueOf(currentProfile.getScore()));
        holder.cardview_fixmessage.setText(currentProfile.getFixMessage());
    }

    @Override
    public int getItemCount() {
        return cadetList.size();
    }

    //Filter
    @Override
    public Filter getFilter() {
        return resultsFilter;
    }

    private Filter resultsFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<DataSender> filtered = new ArrayList<>();

            if(constraint == null || constraint.length() == 0) {
                filtered.addAll(cadetListFull);
            } else {
                String filter_er = constraint.toString().toLowerCase().trim();

                for (DataSender cadet : cadetListFull) {
                    if(cadet.getLast().toLowerCase().contains(filter_er)) {
                        filtered.add(cadet);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filtered;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            cadetList.clear();
            cadetList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

}