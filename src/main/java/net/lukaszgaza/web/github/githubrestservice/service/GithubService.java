package net.lukaszgaza.web.github.githubrestservice.service;

import net.lukaszgaza.web.github.githubrestservice.model.GithubRepositoryInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GithubService {

    private final RestTemplate restTemplate = new RestTemplate();

    // this setting could be moved to properties file
    private final static String GITHUB_API_URL = "https://api.github.com/repos/";

    public GithubRepositoryInfo getRepositoryInfo(String owner, String repositoryName) {
        return restTemplate.getForObject(GITHUB_API_URL + owner + "/" + repositoryName, GithubRepositoryInfo.class);
    }
}
