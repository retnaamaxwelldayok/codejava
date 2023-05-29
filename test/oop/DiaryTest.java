package oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {
    Diary mydiary;
    @BeforeEach public void beforeEach(){
        mydiary = new Diary("userName", "password");
    }

    @Test public void dairyExistTest(){
        assertNotNull(mydiary);
    }

    @Test public void checkDiaryCreatedIsLockeTest(){
        assertTrue(mydiary.isLocked());
    }
    @Test public void unlockLockedDiaryTest(){
        assertTrue(mydiary.isLocked());
        mydiary.unlockDiary("password");
        assertFalse(mydiary.isLocked());
    }
    @Test public void diaryCanNotBeUnlockedWithWrongPasswordTest(){
        assertTrue(mydiary.isLocked());

        mydiary.unlockDiary("retnaa");

        assertTrue(mydiary.isLocked());
    }
    @Test public void lockUnlockedDiaryTest(){
        mydiary.unlockDiary("password");
        assertFalse(mydiary.isLocked());

        mydiary.lockDiary();

        assertTrue(mydiary.isLocked());
    }
    @Test public void canAddGistToUnlockedDiaryEntriesTest(){
        mydiary.unlockDiary("password");
        assertFalse(mydiary.isLocked());

        mydiary.createEntry("title", "body");

        assertEquals(1, mydiary.countGist());
    }
    @Test public void addXY_Gist_GistCountShouldIncreaseAccordinglyTest(){
        mydiary.unlockDiary("password");
        assertFalse(mydiary.isLocked());

        mydiary.createEntry("title", "body");
        mydiary.createEntry("title", "zen");

        assertEquals(2, mydiary.countGist());
    }
    @Test public void addGistAndFindByTitleTest(){
        mydiary.unlockDiary("password");
        assertFalse(mydiary.isLocked());

        mydiary.createEntry("title", "body");
        mydiary.createEntry("Zen", "Be good");

        Entry gist = mydiary.findEntryById(0);
        assertEquals("body", gist.getBody());
    }
    @Test public void testEntryCanBeDeleted(){
        mydiary.unlockDiary("password");
        assertFalse(mydiary.isLocked());
        mydiary.createEntry("title", "body");
        mydiary.createEntry("Zen", "Be good");

        mydiary.deleteEntry(1);

        assertEquals(1, mydiary.countGist());
    }
    @Test public void sumOfSecondDigitsFromLeftToRight(){

    }
}
