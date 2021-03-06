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

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

/**
 *
 * @author Bart.Hanssens
 */
@QuarkusTest
public class CbeResourceTest {
	@Test
    public void testEndpointOrgNT() {
        given()
          .when().accept("application/n-triples").get("/id/cbe/org/0671_516_647")
          .then().statusCode(200);
    }

	@Test
    public void testEndpointOrgJson() {
        given()
          .when().accept("application/ld+json").get("/id/cbe/org/0671_516_647")
          .then().statusCode(200);
    }
	
	@Test
    public void testEndpointSiteNT() {
        given()
          .when().accept("application/n-triples").get("/id/cbe/site/2_147_812_701")
          .then().statusCode(200);
    }

	@Test
    public void testEndpointSiteJson() {
        given()
          .when().accept("application/ld+json").get("/id/cbe/site/2_147_812_701")
          .then().statusCode(200);
    }
}
