/*
 * Copyright 2013-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cloudfoundry.uaa.tokens;

import org.junit.Test;

public final class GetTokenByOpenIdRequestTest {

    @Test(expected = IllegalStateException.class)
    public void noAuthorizationCode() {
        GetTokenByOpenIdRequest.builder()
                .clientId("test-client-id")
                .clientSecret("test-client-secret")
                .redirectUri("test-redirect-uri")
                .tokenFormat(TokenFormat.OPAQUE)
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void noClientId() {
        GetTokenByOpenIdRequest.builder()
                .authorizationCode("test-authorization-code")
                .clientSecret("test-client-secret")
                .redirectUri("test-redirect-uri")
                .tokenFormat(TokenFormat.OPAQUE)
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void noClientSecret() {
        GetTokenByOpenIdRequest.builder()
                .authorizationCode("test-authorization-code")
                .clientId("test-client-id")
                .redirectUri("test-redirect-uri")
                .tokenFormat(TokenFormat.OPAQUE)
                .build();
    }

    @Test
    public void validMax() {
        GetTokenByOpenIdRequest.builder()
                .authorizationCode("test-authorization-code")
                .clientId("test-client-id")
                .clientSecret("test-client-secret")
                .redirectUri("test-redirect-uri")
                .tokenFormat(TokenFormat.OPAQUE)
                .build();
    }

    @Test
    public void validMin() {
        GetTokenByOpenIdRequest.builder()
                .authorizationCode("test-authorization-code")
                .clientId("test-client-id")
                .clientSecret("test-client-secret")
                .build();
    }
}
