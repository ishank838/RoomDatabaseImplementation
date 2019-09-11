package counter.ishank.roomwordssample;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {

    private WordDao wordDao;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        wordDao = db.wordDao();
        mAllWords = wordDao.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word)
    {
        new InsertAsyncTast(wordDao).execute(word);
    }
}
