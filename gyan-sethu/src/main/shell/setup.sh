#!/usr/bin/env bash



#Create collection
curl "http://localhost:8983/solr/admin/collections?action=CREATE&name=step&numShards=1&replicationFactor=1&maxShardsPerNode=2&collection.configName=step"
