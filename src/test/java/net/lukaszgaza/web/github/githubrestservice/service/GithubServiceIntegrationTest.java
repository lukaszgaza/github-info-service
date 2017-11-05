package net.lukaszgaza.web.github.githubrestservice.service;

import lombok.extern.slf4j.Slf4j;
import net.lukaszgaza.web.github.githubrestservice.model.GithubRepositoryInfo;
import org.junit.Test;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.*;

@Slf4j
public class GithubServiceIntegrationTest {

    @Test
    public void shouldReturnRepositoryInfoForCorrectOwnerAndRepository() {
        GithubService githubService = new GithubService();
        GithubRepositoryInfo githubRepositoryInfo = githubService.getRepositoryInfo("lukaszgaza", "datasharing");

        assertEquals("lukaszgaza/datasharing", githubRepositoryInfo.getFullName());
        assertEquals("The Leek group guide to data sharing ", githubRepositoryInfo.getDescription());
        assertEquals("https://github.com/lukaszgaza/datasharing.git", githubRepositoryInfo.getCloneUrl());
        assertTrue(Integer.parseInt(githubRepositoryInfo.getStars()) >= 0);
        assertEquals("2014-05-23T14:35:28Z", githubRepositoryInfo.getCreatedAt());
    }

    @Test
    public void shouldFailIfProvidedIncorrectRepository() {
        GithubService githubService = new GithubService();
        try {
            githubService.getRepositoryInfo("lukaszgaza", "fake_repo");
            fail();
        } catch (HttpClientErrorException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void shouldFailIfProvidedIncorrectUser() {
        GithubService githubService = new GithubService();
        try {
            githubService.getRepositoryInfo("fake_user_lukaszgaza", "datasharing");
            fail();
        } catch (HttpClientErrorException ex) {
            assertTrue(true);
        }
    }
}