package com.kut.with.app;

public class WordDTO {
    public String word;
    public String video;

    public WordDTO(){

    }

    public WordDTO(String word, String video) {
        this.word = word;
        this.video = video;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "WordDTO{" +
                "word='" + word + '\'' +
                ", video='" + video + '\'' +
                '}';
    }
}
