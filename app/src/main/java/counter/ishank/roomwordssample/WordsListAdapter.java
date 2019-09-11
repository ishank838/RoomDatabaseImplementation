package counter.ishank.roomwordssample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordsListAdapter extends RecyclerView.Adapter<WordsListAdapter.WordsListolder> {

    List<Word> mAllWords;

    void setWords(List<Word> words){
        mAllWords = words;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WordsListolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View item=layoutInflater.inflate(R.layout.recycler_view_item,parent,false);
        return new WordsListolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull WordsListolder holder, int position) {
        if (mAllWords != null) {
            Word current = mAllWords.get(position);
            holder.textView.setText(current.getWord());
        } else {
            // Covers the case of data not being ready yet.
            holder.textView.setText("No Word");
        }
    }

    @Override
    public int getItemCount() {
        if(mAllWords==null)
        {
            return 0;
        }
        return mAllWords.size();
    }

     class WordsListolder extends RecyclerView.ViewHolder{

        TextView textView;
        public WordsListolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text_view);
        }
    }
}
