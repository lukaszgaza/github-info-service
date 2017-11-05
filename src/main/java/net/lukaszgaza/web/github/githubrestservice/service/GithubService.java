package net.lukaszgaza.web.github.githubrestservice.service;

import net.lukaszgaza.web.github.githubrestservice.model.GithubRepositoryInfo;
import org.springframework.web.client.RestTemplate;

public class GithubService {

    private final static RestTemplate restTemplate = new RestTemplate();

    private final static String GITHUB_API_URL = "https://api.github.com/repos/";

    public static GithubRepositoryInfo getRepositoryInfo(String owner, String repositoryName) {
        return restTemplate.getForObject(GITHUB_API_URL + owner + "/" + repositoryName, GithubRepositoryInfo.class);
    }
}
