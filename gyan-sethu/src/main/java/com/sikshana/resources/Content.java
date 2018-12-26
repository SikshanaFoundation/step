package com.sikshana.resources;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Content {
    String id;
    String mimeType;
    String fileName;
    String localPath;
    String title;
    String description;
    String keywords;
    Collection<Tags> tags;
    String thumbNail;
    String version;
    LearningMap learnCordinates;
    String teacherGuidance;
    String studentGuidance;
    String downloadUrl;
    String ageGroup;
    String gradeLevel;
    Collection<Reference> references;
    String genre;
    String theme;


    public static class LearningMap{
        String skills;
        String applications;
    }

    private static class Tags{
        String tagName;
        Collection<String> tagValues;
    }

    private static class Reference{
        String source;
        String sourceUrl;
        String biblio;
        String copyright;
        String license;
    }

    private static class Language{
        private String audioLanguage;
        private String subtitle;
    }



}

