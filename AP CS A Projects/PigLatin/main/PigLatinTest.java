


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PigLatinTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PigLatinTest
{
    /**
     * Default constructor for test class PigLatinTest
     */
    public PigLatinTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void cLevelIsVowel()
    {
        assertEquals(true, PigLatin.isVowel("O"));
        assertEquals(true, PigLatin.isVowel("u"));
        assertEquals(false, PigLatin.isVowel("y"));
        assertEquals(false, PigLatin.isVowel("w"));
    }

    // These are the C-Level Tests. Everyone's code should pass these!
    @Test
    public void cLevelConvertWord()
    {
        assertEquals("ellohay", PigLatin.convertWord("hello"));
        assertEquals("aardvarkway", PigLatin.convertWord("aardvark"));
        assertEquals("urritosaregoodbay", PigLatin.convertWord("buRRITOsAreGood"));
        assertEquals("abway", PigLatin.convertWord("AB"));
        assertEquals("eeway", PigLatin.convertWord("Ee"));
        assertEquals("ifay", PigLatin.convertWord("FI"));
        assertEquals("operaway", PigLatin.convertWord("OpErA"));
    }

    /**     B-LEVEL TEST    **/
    //These are the B-Level tests. See if your B-Level passes.
    @Test
    public void bLevelConvertWord()
    {
        assertEquals("agsway", PigLatin.convertWord("Swag"));
        assertEquals("ildrenchay", PigLatin.convertWord("chilDREN"));
        assertEquals("chsbbay", PigLatin.convertWord("bbcHs"));
        assertEquals("zzay", PigLatin.convertWord("ZZ"));
    }

    /**     A-LEVEL TEST    **/
    // Thesea are the A-Level tests. Uncomment this section when you have completed convertSentence
    // @Test
    // public void aLevelConvertSentence()
    // {
        // assertEquals("elphay onlyway easeplay", PigLatin.convertSentence("Help Only Please"));
        // assertEquals("aaway bbay ecay", PigLatin.convertSentence("AA BB CE"));
        // assertEquals("animalsway ayplay amesgay", PigLatin.convertSentence("animals play games"));
    // }
}



