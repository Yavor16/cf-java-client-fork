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

package org.cloudfoundry.client.v3.spaces;

import org.cloudfoundry.client.v3.Relationship;
import org.junit.Test;

public final class AssignSpaceIsolationSegmentRequestTest {

    @Test(expected = IllegalStateException.class)
    public void noOrganizationId() {
        AssignSpaceIsolationSegmentRequest.builder()
                .data(Relationship.builder().id("test-isolation-segment-id").build())
                .build();
    }

    @Test
    public void validData() {
        AssignSpaceIsolationSegmentRequest.builder()
                .data(Relationship.builder().id("test-isolation-segment-id").build())
                .spaceId("test-space-id")
                .build();
    }

    @Test
    public void validNoData() {
        AssignSpaceIsolationSegmentRequest.builder().spaceId("test-space-id").build();
    }
}
