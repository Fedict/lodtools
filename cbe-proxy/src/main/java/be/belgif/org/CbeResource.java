/*
 * Copyright (c) 2020, Bart Hanssens <bart.hanssens@bosa.fgov.be>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package be.belgif.org;

import be.belgif.org.dao.CbeOrganization;
import java.net.URI;
import javax.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 * Proxy endpoint
 * 
 * @author Bart.Hanssens
 */
@Path("/id/cbe")
public class CbeResource {
	@ConfigProperty(name = "be.belgif.org.redirect.org")
	protected String REDIRECT_ORG;

	@ConfigProperty(name = "be.belgif.org.redirect.site")
	protected String REDIRECT_SITE;
			
	@Inject
    @RestClient
	CbePublicSearch pubSearch;

	@GET
	@Path("/org/{id}")
	@Produces({"application/n-triples", "application/ld+json"})
	public CbeOrganization org(@PathParam("id") String id) {
		return pubSearch.getOrgById(id.replace("_", ""));
	}
	@GET
	@Path("/org/{id}")
	@Produces("text/html")
	public Response orgRedirect(@PathParam("id") String id) {
		return Response.seeOther(URI.create(REDIRECT_ORG + id.replace("_", ""))).build();
	}
	
	@GET
	@Path("/site/{id}")
	@Produces({"application/n-triples", "application/ld+json"})
	public CbeOrganization site(@PathParam("id") String id) {
		return pubSearch.getSiteById(id.replace("_", ""));
	}
	@GET
	@Path("/site/{id}")
	@Produces("text/html")
	public Response siteRedirect(@PathParam("id") String id) {
		return Response.seeOther(URI.create(REDIRECT_SITE + id.replace("_", ""))).build();
	}
}
