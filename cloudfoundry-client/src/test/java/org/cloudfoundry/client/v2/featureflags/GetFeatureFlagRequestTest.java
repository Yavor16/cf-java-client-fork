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

package org.cloudfoundry.client.v2.featureflags;

import org.junit.Test;

public final class GetFeatureFlagRequestTest {

    @Test(expected = IllegalStateException.class)
    public void badName1() {
        GetFeatureFlagRequest.builder()
                .name("mustn't have spaces or / chars (or quotes, or parentheses, or commas)")
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void badName2() {
        GetFeatureFlagRequest.builder().name("good_name_with_bad_at_end ").build();
    }

    @Test(expected = IllegalStateException.class)
    public void badName3() {
        GetFeatureFlagRequest.builder().name("good_name_with_bad_at_end.").build();
    }

    @Test(expected = IllegalStateException.class)
    public void noName() {
        GetFeatureFlagRequest.builder().build();
    }

    @Test
    public void valid() {
        GetFeatureFlagRequest.builder().name("test_feature_flag_name").build();
    }
}
