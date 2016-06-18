package com.performgroup.ott.interview.loader.commands;

import com.performgroup.ott.interview.api.update.GraphDto;
import com.performgroup.ott.interview.api.update.NodeDto;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.client.RestTemplate;

import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lukasz on 17/06/16.
 */
class LoadGraphCommand implements Command {
    public static final int NUMBER_OF_REQUIRED_PARAMETERS_FOR_LOAD_COMMAND = 2;
    public static final int COMMAND_NAME_INDEX = 0;
    public static final int DIR_PATH_INDEX = 1;
    public static final String LOAD_COMMAND_LINE_NAME = "load";
    private String[] options = new String[]{};
    private Jaxb2Marshaller marshaller;
    private String dirPath;

    public LoadGraphCommand(String[] options) {
        validateParameters(options);
        this.options = options;
        this.dirPath = options[DIR_PATH_INDEX];
        File dir = new File(dirPath);
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("Provided path is not directory path");
        }
        this.marshaller = new Jaxb2Marshaller();
        this.marshaller.setClassesToBeBound(NodeDto.class);
    }

    private void validateParameters(String[] options) {
        if (options.length != NUMBER_OF_REQUIRED_PARAMETERS_FOR_LOAD_COMMAND) {
            throw new IllegalArgumentException("Incorrect number of  parameters provided for this command");
        }
        if (!LOAD_COMMAND_LINE_NAME.equals(options[COMMAND_NAME_INDEX])) {
            throw new IllegalArgumentException("Bad command provided");
        }
    }

    @Override
    public void execute() {
        File dir = new File(dirPath);
        List<NodeDto> nodes = new ArrayList<>();
        File[] files = dir.listFiles();
        for (File file : files) {
            NodeDto dto = unmarshalNodeFromFile(file);
            nodes.add(dto);
        }
        GraphDto graphDto = new GraphDto();
        graphDto.setNodes(nodes);
        addGraph(graphDto);
    }

    private NodeDto unmarshalNodeFromFile(File file) {
        NodeDto dto;
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            dto = (NodeDto) marshaller.unmarshal(new StreamSource(new FileInputStream(file)));
        } catch (Exception e) {
            throw new RuntimeException("Problem with reading file " + e.getMessage());
        } finally {
            IOUtils.closeQuietly(is);
        }
        return dto;
    }

    private void addGraph(GraphDto graphDto) {
        RestTemplate template = new RestTemplate();
        template.setMessageConverters(Arrays.<HttpMessageConverter<?>>asList(new MappingJackson2HttpMessageConverter()));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<GraphDto> entity = new HttpEntity<>(graphDto, headers);
        template.exchange("http://localhost:40000/graph", HttpMethod.POST, entity, String.class);
    }
}
