package com.andrianigiordano.springboot.movies;


public class MovieDTO {
    private Long id;

    private String title;

    private String date;

    private String posterUrl;

    private String tagline;

    private String description;

    private Double rating;
    private Integer minute;



    public MovieDTO(Long id, String title, String date, String tagline, String description, String posterUrl, Double rating, Integer minute) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.tagline = tagline;
        this.description = description;
        this.posterUrl = posterUrl;
        this.rating = rating;
        this.minute = minute;
    }


    // Getter e Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
    @Override
    public String toString() {
        return "MovieDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tagline='" + tagline + '\'' +
                ", description='" + description + '\'' +
                ", posterUrl='" + posterUrl + '\'' +
                ", date='" + date + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
