package com.sm.monitor;

import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Endpoint(id = "release-notes")
public class CustomEndpoint {

    Map<String, List<String>> releaseNotesMap = new LinkedHashMap<>();

    @PostConstruct
    public void initNotes() {
        releaseNotesMap.put("v-1.0", Arrays.asList("User Registration added", "Anyone can register in website"));
        releaseNotesMap.put("v-1.1", Arrays.asList("Login functionality added", "Login with username and password"));
    }

    @ReadOperation
    public Map<String, List<String>> getReleaseNotes(){
        return releaseNotesMap;
    }

    /**
     * use postman to get release-notes by version
     * @param version
     * @return
     */
    @ReadOperation
    public List<String> getNotesByVersion(@Selector String version){
        return releaseNotesMap.get(version);
    }

    /**
     * Use postman to add release-notes in runtime
     * @param version
     * @param releaseNotes
     */
    @WriteOperation
    public void addReleaseNotes(@Selector String version, String releaseNotes){
        releaseNotesMap.put(version,Arrays.stream(releaseNotes.split(",")).collect(Collectors.toList()));
    }

    @DeleteOperation
    public void  deleteNotes(@Selector String version){
        releaseNotesMap.remove(version);
    }
}
