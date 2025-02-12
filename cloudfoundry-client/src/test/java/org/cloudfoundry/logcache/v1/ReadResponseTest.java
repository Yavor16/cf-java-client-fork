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

package org.cloudfoundry.logcache.v1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ReadResponseTest {

    @Test
    public void missingEnvelopes() {
        assertThat(ReadResponse.builder().build().getEnvelopes()).isNotNull();
    }

    @Test
    public void valid() {
        ReadResponse.builder().envelopes(EnvelopeBatch.builder().build()).build();
    }
}
