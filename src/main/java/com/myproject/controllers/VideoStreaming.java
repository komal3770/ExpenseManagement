package com.myproject.controllers;

import java.io.File;
import java.net.URL;

import javax.ws.rs.HEAD;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/videoStreaming")
public class VideoStreaming extends ResourceConfig{
	final static Logger logger = LoggerFactory.getLogger( HomeController.class );
	
	private static final String FILE_PATH = "D:/video-sample.3gp";
    private final int chunk_size = 1024 * 1024 * 2; // 2 MB chunks
    
    
 // for clients to check whether the server supports range / partial content requests
    @HEAD
    @Path("/stream")
    @Produces("video/mp4")
    public Response header() {
    	logger.info("@HEAD request received");
    	
        URL url = this.getClass().getResource( FILE_PATH );
        File file = new File( url.getFile() );
        
        return Response.ok()
        		.status( Response.Status.PARTIAL_CONTENT )
        		.header( HttpHeaders.CONTENT_LENGTH, file.length() )
        		.header( "Accept-Ranges", "bytes" )
        		.build();
    }
}
