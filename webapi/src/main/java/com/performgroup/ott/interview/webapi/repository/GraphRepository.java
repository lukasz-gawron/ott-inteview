package com.performgroup.ott.interview.webapi.repository;

import com.performgroup.ott.interview.webapi.domain.Graph;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring data Elasticsearch repository, requires definition of interface and works out of the box for default settings
 * which are fine for now for this POC
 *
 * Created by lukasz.gawron on 17/06/16.
 */
public interface GraphRepository extends ElasticsearchRepository<Graph, String> {

}
