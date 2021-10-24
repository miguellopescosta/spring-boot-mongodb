package com.exercise.quotes50k.models;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "quotes")
public class Quote {

    @Id
    private String _id;
    private String quoteText;
    private String quoteAuthor;
    private String quoteGenre;
    private Long __v;

    public Quote(){}

    public Quote(String _id,String quoteText, String quoteAuthor, String quoteGenre, Long __v) {
        super();
        this._id = _id;
        this.quoteText = quoteText;
        this.quoteAuthor = quoteAuthor;
        this.quoteGenre = quoteGenre;
        this.__v = __v;
    }
}
