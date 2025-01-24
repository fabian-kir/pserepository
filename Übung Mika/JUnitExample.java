

public class JUnitExample {
        @Test
        public void testExample() {
            assertEquals(100, 110, "Wrong number returned"); //expected 100, actual 110, message "Wrong number returned"
            assertTrue(100 < 101);
            assertEquals("Test", "Test"); //Tut
            assertSame("Test", "Test"); //tut nicht, prüft auf Refenrezngleichheit (zwei Strings sind nucht Referent gleich)

        }
}