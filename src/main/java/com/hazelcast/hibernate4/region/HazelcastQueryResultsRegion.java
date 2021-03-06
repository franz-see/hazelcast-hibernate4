/*
 * Copyright (c) 2008-2012, Hazel Bilisim Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.hibernate4.region;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.hibernate4.local.LocalRegionCache;
import org.hibernate.cache.spi.QueryResultsRegion;

import java.util.Properties;

public class HazelcastQueryResultsRegion extends AbstractGeneralRegion<LocalRegionCache> implements QueryResultsRegion {

    public HazelcastQueryResultsRegion(final HazelcastInstance instance, final String name, final Properties props) {
        // Note: We can pass HazelcastInstance as null, because instead of invalidation
        // timestamps cache can take care of outdated queries.
        super(instance, name, props, new LocalRegionCache(name, null, null));
    }
}
