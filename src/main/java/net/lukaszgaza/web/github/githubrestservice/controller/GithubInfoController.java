package net.lukaszgaza.web.github.githubrestservice.controller;

import lombok.extern.slf4j.Slf4j;
import net.lukaszgaza.web.github.githubrestservice.model.GithubRepositoryInfo;
import net.lukaszgaza.web.github.githubrestservice.service.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@Slf4j
public class GithubInfoController {

    private GithubService githubService;

    @Autowired
    public GithubInfoController(GithubService githubService) {
        this.githubService = githubService;
    }

    @RequestMapping(value = "/repositories/{owner}/{repositoryName}", method = RequestMethod.GET)
    public GithubRepositoryInfo getRepositoryInfo(@PathVariable String owner,
                                              @PathVariable String repositoryName) {
        // TODO - On purpose I'm ignoring here any validation of input data
        log.info("Received request for owner={}, repositoryName={}", owner, repositoryName);
        try {
            return githubService.getRepositoryInfo(owner, repositoryName);
        } catch (HttpClientErrorException ex) {
            log.warn("Exception during Github API request", ex.getMessage());
            return null;
        }
    }
}