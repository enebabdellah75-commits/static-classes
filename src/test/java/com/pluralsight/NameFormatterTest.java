package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameFormatterTest {
    @Test
    public void testFormatFirstAndLastName() {
        assertEquals("Johnson, Mel",
                NameFormatter.format("Mel", "Johnson"));
    }

    @Test
    public void testFormatWithAllNameParts() {
        assertEquals("Johnson, Dr. Mel B, PhD",
                NameFormatter.format("Dr.", "Mel", "B", "Johnson", "PhD"));
    }

    @Test
    public void testFormatWithoutOptionalParts() {
        assertEquals("Johnson, Mel",
                NameFormatter.format("", "Mel", "", "Johnson", ""));
    }

    @Test
    public void testFormatFullNameWithPrefixAndSuffix() {
        assertEquals("Johnson, Dr. Mel B, PhD",
                NameFormatter.format("Dr. Mel B Johnson, PhD"));
    }

    @Test
    public void testFormatFullNameWithoutPrefixAndSuffix() {
        assertEquals("Johnson, Mel",
                NameFormatter.format("Mel Johnson"));
    }

}