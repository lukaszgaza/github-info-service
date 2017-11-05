package net.lukaszgaza.web.github.githubrestservice.controller;

import net.lukaszgaza.web.github.githubrestservice.model.GithubRepositoryInfo;
import net.lukaszgaza.web.github.githubrestservice.service.GithubService;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GithubInfoControllerTest {

    private static GithubService githubService = mock(GithubService.class);

    @BeforeClass
    public static void beforeAll() {
        GithubRepositoryInfo githubRepositoryInfo = new GithubRepositoryInfo("lukaszgaza/datasharing",
                "The Leek group guide to data sharing ", "https://github.com/lukaszgaza/datasharing.git",
                "0", "2014-05-23T14:35:28Z");
        when(githubService.getRepositoryInfo("someOwner", "someRepo")).thenReturn(githubRepositoryInfo);
        when(githubService.getRepositoryInfo("incorrectOwner", "someRepo")).thenReturn(null);
        when(githubService.getRepositoryInfo("someOwner", "incorrectRepo")).thenReturn(null);
    }

    @Test
    public void shouldReturnRepositoryInfoForCorrectOwnerAndRepository() {
        GithubInfoController githubInfoController = new GithubInfoController(githubService);

        GithubRepositoryInfo expectedGithubRepositoryInfo = new GithubRepositoryInfo("lukaszgaza/datasharing",
                "The Leek group guide to data sharing ", "https://github.com/lukaszgaza/datasharing.git",
                "0", "2014-05-23T14:35:28Z");

        assertEquals(expectedGithubRepositoryInfo, githubInfoController.getRepositoryInfo("someOwner", "someRepo"));
    }

    @Test
    public void shouldReturnNullInfoIfProvidedIncorrectRepository() {
        GithubInfoController githubInfoController = new GithubInfoController(githubService);

        assertEquals(null, githubInfoController.getRepositoryInfo("someOwner", "incorrectRepo"));
    }

    @Test
    public void shouldReturnNullInfoIfProvidedIncorrectUser() {
        GithubInfoController githubInfoController = new GithubInfoController(githubService);

        assertEquals(null, githubInfoController.getRepositoryInfo("incorrectOwner", "someRepo"));
    }
}