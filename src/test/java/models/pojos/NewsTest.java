package models.pojos;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@Disabled
@DisplayName("News class test")
class NewsTest {

    @DisplayName("Check if news Instantiates correctly")
    @Test
    void news_instantiatesCorrectly_True(){

        News testNews = new News("today this and this happened","Tanui");

        assertTrue(testNews instanceof News);

    }
    @DisplayName("Check if news returns content")
    @Test
    void getContent_instantiatesCorrectly_True(){

        News testNews = new News("today this and this happened","Tanui");

        assertEquals("today this and this happened",testNews.getContent());

    }
    @DisplayName("Check if news returns author")
    @Test
    void getAuthor_instantiatesCorrectly_True(){

        News testNews = new News("today this and this happened","Tanui");

        assertEquals("Tanui",testNews.getAuthor());

    }

    @DisplayName("Check if two instances of news are same")
    @Test
    void equals_checkIfTwoInstancesOfNewsAreEqual_True(){

        News testNewsOne = new News("today this and this happened","Tanui");
        News testNewsTwo = new News("today this and this happened","Tanui");

        assertTrue(testNewsTwo.equals(testNewsOne));

    }

}