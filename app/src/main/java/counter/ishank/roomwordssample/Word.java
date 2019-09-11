package counter.ishank.roomwordssample;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;


@Entity(tableName = "word_table")
public class Word {
    @PrimaryKey
    @NotNull
    @ColumnInfo(name="word")
    private String mWord;

    public Word(@NotNull String word)
    {
        this.mWord=word;
    }
    public String getWord()
    {
        return this.mWord;
    }
}
