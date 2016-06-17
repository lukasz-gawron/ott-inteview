package com.performgroup.ott.interview.webapi.controller;

import com.performgroup.ott.interview.api.update.GraphDto;
import com.performgroup.ott.interview.webapi.App;
import com.performgroup.ott.interview.webapi.domain.GraphDtoMother;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;


/**
 * Created by lukasz on 17/06/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebIntegrationTest("server.port:40000")
public class ApiIT {

    RestTemplate template = new TestRestTemplate();

    @Before
    public void setUp() throws Exception {
        template.setMessageConverters(asList(new MappingJackson2HttpMessageConverter()));

    }

    @Test
    public void should_post_new_graph_and_receive_200_status_code_when_nodes_and_edges_are_correct() throws Exception {
        //given
        GraphDto graphDto = GraphDtoMother.aGraphDto();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<GraphDto> entity = new HttpEntity<>(graphDto, headers);

        //when
        ResponseEntity<String> response = template.exchange("http://localhost:40000/graph", HttpMethod.POST, entity, String.class);

        //then
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}
