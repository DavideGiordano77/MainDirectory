package com.andrianigiordano.springboot.actors;

public class ActorsDTO {


    private Long id;

    private String title;

    private String actors_name;

    private Double rating;

    public ActorsDTO(Long id, String title, Double rating, String actors_name) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.actors_name = actors_name;
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

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getActors_name() {
        return actors_name;
    }

    public void setActors_name(String actors_name) {
        this.actors_name = actors_name;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating='" + rating + '\'' +
                ", actors_name='" + actors_name + '\'' +
                '}';
    }
}

