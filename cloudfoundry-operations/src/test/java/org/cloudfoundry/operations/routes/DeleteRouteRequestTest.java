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

package org.cloudfoundry.operations.routes;

import org.junit.Test;

public final class DeleteRouteRequestTest {

    @Test(expected = IllegalStateException.class)
    public void noDomain() {
        DeleteRouteRequest.builder().build();
    }

    @Test(expected = IllegalStateException.class)
    public void setupConflict() {
        DeleteRouteRequest.builder().domain("test-domain").host("test-hostname").port(123).build();
    }

    @Test
    public void valid() {
        DeleteRouteRequest.builder().domain("test-domain").build();
    }
}
