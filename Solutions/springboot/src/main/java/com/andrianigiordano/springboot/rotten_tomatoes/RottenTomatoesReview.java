package com.andrianigiordano.springboot.rotten_tomatoes;

import jakarta.persistence.*;

@Entity
@Table(name = "rotten_tomatoes_reviews")
public class RottenTomatoesReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "link", nullable = false)
    private String link;

    @Column(name = "movie_title", nullable = false)
    private String movieTitle;

    @Column(name = "critic_name")
    private String criticName;

    @Column(name = "top_critic")
    private Boolean topCritic;

    @Column(name = "publisher_name")
    private String publisherName;

    @Column(name = "review_type")
    private String reviewType;

    @Column(name = "review_score")
    private Double reviewScore;

    @Column(name = "review_date")
    private String reviewDate;

    @Column(name = "review_content", columnDefinition = "TEXT")
    private String reviewContent;

    public RottenTomatoesReview() {
    }

    public RottenTomatoesReview(String link, String movieTitle, String criticName, Boolean topCritic, String publisherName, String reviewType, Double reviewScore, String reviewDate, String reviewContent) {
        this.link = link;
        this.movieTitle = movieTitle;
        this.criticName = criticName;
        this.topCritic = topCritic;
        this.publisherName = publisherName;
        this.reviewType = reviewType;
        this.reviewScore = reviewScore;
        this.reviewDate = reviewDate;
        this.reviewContent = reviewContent;
    }

    public Long getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getCriticName() {
        return criticName;
    }

    public void setCriticName(String criticName) {
        this.criticName = criticName;
    }

    public Boolean getTopCritic() {
        return topCritic;
    }

    public void setTopCritic(Boolean topCritic) {
        this.topCritic = topCritic;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getReviewType() {
        return reviewType;
    }

    public void setReviewType(String reviewType) {
        this.reviewType = reviewType;
    }

    public Double getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(Double reviewScore) {
        this.reviewScore = reviewScore;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }
}
