package counter.ishank.roomwordssample;

import android.os.AsyncTask;

public class InsertAsyncTast extends AsyncTask<Word,Void,Void> {
    public WordDao worddao;
    InsertAsyncTast(WordDao worddao){
        this.worddao=worddao;
    }

    @Override
    protected Void doInBackground(Word... words) {
        worddao.insert(words[0]);
        return null;
    }
}