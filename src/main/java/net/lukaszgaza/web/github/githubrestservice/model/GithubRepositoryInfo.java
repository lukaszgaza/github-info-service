package net.lukaszgaza.web.github.githubrestservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class GithubRepositoryInfo {

    private String fullName;
    private String description;
    private String cloneUrl;
    private String stars;
    private String createdAt;

    @JsonProperty("full_name")
    public void setFull_name(String fullName) {
        this.fullName = fullName;
    }

    @JsonProperty("clone_url")
    public void setClone_url(String cloneUrl) {
        this.cloneUrl = cloneUrl;
    }

    @JsonProperty("stargazers_count")
    public void setStargazers_count(String stars) {
        this.stars = stars;
    }

    @JsonProperty("created_at")
    public void setCreated_at(String createdAt) {
        this.createdAt = createdAt;
    }
}