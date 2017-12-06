/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.rest.service;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author adsi1261718
 */
@ApplicationPath("api")
public class AppConfig extends ResourceConfig{
     public AppConfig() {
        //packages("co.edu.sena.adsi.rest.services");
    }
}
