package com.performgroup.ott.interview.webapi.repository;

import com.performgroup.ott.interview.webapi.domain.Graph;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by lukasz.gawron on 17/06/16.
 */
public interface GraphRepository extends ElasticsearchRepository<Graph, String> {

}
