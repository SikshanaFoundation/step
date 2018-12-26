package com.sikshana.resources;

import com.google.common.graph.Traverser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Consumer;

public class ContentCrawler {

    public static void main(String[] args) throws  Exception{

        Traverser<File> fileTraverser = com.google.common.io.Files.fileTraverser();
        String rootDir = "/home/umesh/sikshana/step/sikshana/2018 -2019 Project Content/Karnataka/Grade 6/Articles";//args[0];
        File rootFile = new File(rootDir);
        Iterable<File> iterable = fileTraverser.depthFirstPostOrder(rootFile);
        FileProcessor fileProcessor = new FileProcessor();

        iterable.forEach(fileProcessor);
        Collection<String> allFiles = new HashSet<>();
        for(Content c:fileProcessor.contents){
            allFiles.add(c.fileName);
        }
        System.out.println(allFiles);

        SearchClient searchClient = new SearchClient();

        searchClient.indexContent("step", fileProcessor.contents);
    }

    private static class FileProcessor implements Consumer<File>{

        Collection<Content> contents = new HashSet<>();

        FileProcessor(){

        }

        @Override
        public void accept(File file) {
            String mimeType = null;
            String id = file.getName();
            String ageGroup = "10";
            String downloadUrl = file.getAbsolutePath();
            try{ mimeType = Files.probeContentType(file.toPath());
            }catch(IOException e){

            }
            Content content =  Content.builder().id(id).ageGroup(ageGroup).downloadUrl(downloadUrl).title(file.getName()).fileName(file.getName()).localPath(file.getAbsolutePath()).mimeType(mimeType).
                    build() ;

            contents.add(content);
//            System.out.println(file);
        }
    }




}
