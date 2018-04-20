/*
 * Copyright 2013 Nicolas Morel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dominokit.jacksonapt.ser.collection;

import org.dominokit.jacksonapt.JsonSerializer;
import org.dominokit.jacksonapt.ser.AbstractJsonSerializerTest;
import org.dominokit.jacksonapt.ser.IterableJsonSerializer;
import org.dominokit.jacksonapt.ser.StringJsonSerializer;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Nicolas Morel
 */
public class ListJsonSerializerTest extends AbstractJsonSerializerTest<List<String>> {

    @Override
    protected JsonSerializer<List<String>> createSerializer() {
        return (JsonSerializer) IterableJsonSerializer.newInstance(StringJsonSerializer.getInstance());
    }

    @Test
	public void testSerializeValue() {
        assertSerialization("[\"Hello\",\" \",\"World\",\"!\"]", Arrays.asList("Hello", " ", "World", "!"));
        assertSerialization("[]", Collections.<String>emptyList());
    }

}