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

package org.cloudfoundry.client.v2.buildpacks;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;

public final class UploadBuildpackRequestTest {

    private static final Path TEST_BUILDPACK = Paths.get("/");

    @Test(expected = IllegalStateException.class)
    public void noBuildpack() {
        UploadBuildpackRequest.builder()
                .buildpackId("test-buildpack-id")
                .filename("test-filename")
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void noBuildpackId() {
        UploadBuildpackRequest.builder()
                .buildpack(TEST_BUILDPACK)
                .filename("test-filename")
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void noFilename() {
        UploadBuildpackRequest.builder()
                .buildpack(TEST_BUILDPACK)
                .buildpackId("test-buildpack-id")
                .build();
    }

    @Test
    public void valid() {
        UploadBuildpackRequest.builder()
                .buildpack(TEST_BUILDPACK)
                .buildpackId("test-buildpack-id")
                .filename("test-filename")
                .build();
    }
}
