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

package org.cloudfoundry.client.v2.applications;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;

public final class UploadApplicationRequestTest {

    private static final Path TEST_APPLICATION = Paths.get("/");

    @Test(expected = IllegalStateException.class)
    public void noApplication() {
        UploadApplicationRequest.builder().applicationId("test-application-id").build();
    }

    @Test(expected = IllegalStateException.class)
    public void noApplicationId() {
        UploadApplicationRequest.builder().application(TEST_APPLICATION).build();
    }

    @Test
    public void valid() {
        UploadApplicationRequest.builder()
                .application(TEST_APPLICATION)
                .applicationId("test-application-id")
                .build();
    }
}
