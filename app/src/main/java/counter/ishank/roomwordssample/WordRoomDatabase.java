package counter.ishank.roomwordssample;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import io.reactivex.internal.util.ArrayListSupplier;

@Database(entities = Word.class,version = 1,exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {


    public abstract WordDao wordDao();

    private static volatile WordRoomDatabase instance;

    static WordRoomDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (WordRoomDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return instance;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {

                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDatabase(instance).execute();
                }
            };

    private static class PopulateDatabase extends AsyncTask<Word,Void,Void>{

        private WordDao wordDao;
        String[] wordslist={"dolphin","tiger","Lion"};
        public PopulateDatabase(WordRoomDatabase wordDao) {
            this.wordDao = wordDao.wordDao();
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.deleteAll();

            for(int i=0;i<words.length;i++)
            {
                Word word=new Word(wordslist[i]);
                wordDao.insert(word);
            }
            return null;
        }
    }
}
