package edu.uncw.seahawktours;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Filter;
import java.util.ArrayList;
import java.util.List;
import android.util.Log;


class CaptionedImagesAdapter extends
        RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder> implements Filterable {

    private List<SearchListItem> searchListItems;
    private List<SearchListItem> searchListItemsFull;
    private OnItemClickListener mListener;

    //Get position
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        ViewHolder(final CardView itemView, final OnItemClickListener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.info_image);
            textView = itemView.findViewById(R.id.info_text);


            //Create listener for card
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        long id = getAdapterPosition();
                        if (id != RecyclerView.NO_POSITION) {
                            listener.onItemClick((int)id);
                        }
                    }
                }
            });
        }
    }

    //Initialize Search Items
    CaptionedImagesAdapter(List<SearchListItem> searchListItems){
        this.searchListItems = searchListItems;
        searchListItemsFull = new ArrayList<>(searchListItems);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        CardView v = (CardView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_captioned_image,
                viewGroup, false);
        return new ViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SearchListItem currentItem = searchListItems.get(position);
        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.textView.setText(currentItem.getText1());
    }

    @Override
    public int getItemCount() { return searchListItems.size(); }

    @Override
    public Filter getFilter() { return listFilter; }

    //Filter list
    private Filter listFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<SearchListItem> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(searchListItemsFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (SearchListItem item : searchListItemsFull) {
                    if (item.getText1().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        //Resets list when filtered
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            searchListItems.clear();
            searchListItems.addAll((List) results.values);
            notifyDataSetChanged();
        }


    };


}




