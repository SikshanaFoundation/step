package com.sikshana.resources;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SearchClient {

    private org.apache.solr.client.solrj.SolrClient client;

    SearchClient(){
        client = new  HttpSolrClient.Builder().withBaseSolrUrl("http://localhost:8983/solr").build();

    }

    public void indexContent(String collection, Collection<Content> list) throws  Exception{
        List<SolrInputDocument> solrDocList = new LinkedList<>();
        for(Content content:list) {
            solrDocList.add(toSolrDoc(content));
        }

        client.add(collection,solrDocList);
        client.commit(collection);
    }

    private static enum Fields{
        id, fileName, title, fullPath
    }

    private static SolrInputDocument toSolrDoc(Content content){
        SolrInputDocument doc  = new SolrInputDocument();
        doc.addField(Fields.fileName.toString(), content.getFileName());
        doc.addField(Fields.id.toString(),content.getId());
        doc.addField(Fields.fullPath.toString(),content.getLocalPath());
        doc.addField(Fields.title.toString(),content.getTitle());
        return doc;
    }
}
