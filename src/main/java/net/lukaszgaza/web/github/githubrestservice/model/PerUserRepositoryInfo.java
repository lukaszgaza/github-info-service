package net.lukaszgaza.web.github.githubrestservice.model;

public class RepositoryInfo {
    private final String fullName;
    private final String description;
    private final String cloneUrl;
    private final int stars;
    private final String createdAt; // TODO should be ISO format

    public RepositoryInfo(String fullName, String description,
                          String cloneUrl, int stars,
                          String createdAt) {
        this.fullName = fullName;
        this.description = description;
        this.cloneUrl = cloneUrl;
        this.stars = stars;
        this.createdAt = createdAt;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }

    public String getCloneUrl() {
        return cloneUrl;
    }

    public int getStars() { // should be returned as string
        return stars;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
